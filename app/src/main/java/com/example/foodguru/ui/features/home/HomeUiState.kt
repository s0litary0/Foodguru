package com.example.foodguru.ui.features.home

import com.example.foodguru.data.source.network.NetworkRecipe


sealed class HomeUiState {
    data class Success(val recipeOfTheDay: NetworkRecipe) : HomeUiState()
    data object Loading : HomeUiState()
    data class Empty(val message: String?) : HomeUiState()
    data class Error(val message: String?) : HomeUiState()
}
