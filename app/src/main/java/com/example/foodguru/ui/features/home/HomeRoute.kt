package com.example.foodguru.ui.features.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.AppLoader
import com.example.foodguru.ui.components.ScreenLayout

@Composable
fun HomeRoute(
    onRecipeClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier,
    ) {
        when (val state = uiState) {
            is HomeUiState.Loading -> {
                AppLoader()
            }
            is HomeUiState.Error -> {
                Text(text = state.message ?: "Unknown error")
            }
            is HomeUiState.Empty -> {
                Text(text = state.message ?: "Unknown error")
            }
            is HomeUiState.Success -> {
                HomeScreen(
                    recipeOfTheDay = state.recipeOfTheDay,
                    onRecipeClick = onRecipeClick
                )
            }
        }
    }
}
