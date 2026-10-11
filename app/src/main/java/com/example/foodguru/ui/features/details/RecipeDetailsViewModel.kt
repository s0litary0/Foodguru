package com.example.foodguru.ui.features.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foodguru.FoodguruApplication
import com.example.foodguru.data.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


private const val TAG: String = "ViewModel"


class RecipeDetailsViewModel(
    private val recipeRepository: RecipeRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _recipeId = savedStateHandle.getStateFlow("recipe_id", 1L)

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val recipeRepository = (this[APPLICATION_KEY] as FoodguruApplication).recipeRepository
                RecipeDetailsViewModel(
                    recipeRepository = recipeRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }

    private val _uiState = MutableStateFlow<RecipeDetailsUiState>(
        RecipeDetailsUiState.Loading
    )
    val uiState = _uiState.asStateFlow()

    init {
        Log.d(TAG, "ViewModel init - this@RecipeDetailsViewModel = $this")
        getRecipeDetails(_recipeId.value)
    }

    override fun onCleared() {
        Log.d(TAG, "ViewModel onCleared - this@RecipeDetailsViewModel = $this")
        super.onCleared()
    }

    private fun getRecipeDetails(id: Long) {
        viewModelScope.launch {
            _uiState.update { RecipeDetailsUiState.Loading }
            try {
//                val recipe = recipeRepository.getRecipeById(id, shouldFail = true)
                val recipe = recipeRepository.getRecipeById(id)
                if (recipe == null) {
                    _uiState.update { RecipeDetailsUiState.Empty(
                        message = "No recipe with such id found"
                    ) }
                } else {
                    _uiState.update { RecipeDetailsUiState.Success(
                        recipe = recipe
                    ) }
                }
            } catch (e: Exception) {
                _uiState.update { RecipeDetailsUiState.Error(message = e.message) }
            }
        }
    }

    fun onSave() {

    }

}