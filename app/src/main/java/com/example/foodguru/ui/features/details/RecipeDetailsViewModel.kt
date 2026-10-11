package com.example.foodguru.ui.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodguru.ui.features.search.Recipe
//import com.example.foodguru.ui.features.search.getRecipesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



sealed class RecipeDetailsUiState {
    data class Success(val recipe: Recipe) : RecipeDetailsUiState()
    object Loading : RecipeDetailsUiState()
}

class RecipeDetailsViewModel(val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _recipeId = savedStateHandle.getStateFlow("recipe_id", 1L)
    private val _uiState: MutableStateFlow<RecipeDetailsUiState> =
        MutableStateFlow(RecipeDetailsUiState.Loading)

    val uiState: StateFlow<RecipeDetailsUiState> = _uiState.asStateFlow()

    init {
//        _uiState.value = RecipeDetailsUiState.Success(
//            recipe = getRecipeById(_recipeId.value)
//        )
    }

    fun onSave() {

    }
}