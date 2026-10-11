package com.example.foodguru.ui.features.search;

import com.example.foodguru.data.source.network.NetworkRecipe

sealed class SearchUiState {
    data class Success(
        val recipes: List<NetworkRecipe>,
        val tags: List<Tag>,
        val selectedTags: List<Tag>,
        val searchResults: List<String>
    ) : SearchUiState()
    object Loading : SearchUiState()
//    data class Empty(val message: String?): SearchUiState()
    data class Error(val message: String?): SearchUiState()
}
