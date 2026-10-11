package com.example.foodguru.ui.features.details

import com.example.foodguru.data.source.network.NetworkRecipe


sealed class RecipeDetailsUiState {
    data class Success(val recipe: NetworkRecipe) : RecipeDetailsUiState()
    object Loading : RecipeDetailsUiState()
    data class Empty(val message: String?) : RecipeDetailsUiState()
    data class Error(val message: String?) : RecipeDetailsUiState()
}