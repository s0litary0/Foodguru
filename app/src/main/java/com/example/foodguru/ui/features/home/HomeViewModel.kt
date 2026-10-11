package com.example.foodguru.ui.features.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.foodguru.FoodguruApplication
import com.example.foodguru.data.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


private const val TAG: String = "ViewModel"


class HomeViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(
            HomeUiState.Loading
        )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        Log.d(TAG, "ViewModel init - this@HomeViewModel = $this")
        getRecipeOfTheDay()
    }

    override fun onCleared() {
        Log.d(TAG, "ViewModel onCleared - this@HomeViewModel = $this")
        super.onCleared()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val recipeRepository = (this[APPLICATION_KEY] as FoodguruApplication).recipeRepository
                HomeViewModel(
                    recipeRepository = recipeRepository
                )
            }
        }
    }

    private fun getRecipeOfTheDay() {
        viewModelScope.launch {
            _uiState.update { HomeUiState.Loading }
            try {
                val recipe = recipeRepository.getRecipeOfTheDay()
                _uiState.update { HomeUiState.Success(recipeOfTheDay = recipe) }
            } catch (e: Exception) {
                _uiState.update { HomeUiState.Error(message = e.message) }
            }
        }
    }
}
