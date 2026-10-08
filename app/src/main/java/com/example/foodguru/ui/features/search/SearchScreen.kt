package com.example.foodguru.ui.features.search

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.ScreenLayout

@Composable
fun SearchScreen(
    onRecipeClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier
    ) {
        when(val state = uiState) {
            is SearchUiState.Loading -> {
                Text(text = "Loading")
            }
            is SearchUiState.Success -> {
                SearchScreenContent(
                    recipes = state.recipes,
                    tags = state.tags,
                    selectedTags = state.selectedTags,
                    toggleTag = viewModel::toggleTag,
                    onRecipeClick = onRecipeClick,
                    textFieldState = viewModel.textFieldState,
                    searchResults = state.searchResults,
                    onSearch = { query -> viewModel.onSearch(query) }
                )
            }
        }
    }
}