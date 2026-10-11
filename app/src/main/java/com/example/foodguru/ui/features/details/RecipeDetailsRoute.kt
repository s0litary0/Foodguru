package com.example.foodguru.ui.features.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.AppLoader
import com.example.foodguru.ui.components.ScreenLayout


@Composable
fun RecipeDetailsRoute(
    modifier: Modifier = Modifier,
    viewModel : RecipeDetailsViewModel = viewModel(factory = RecipeDetailsViewModel.Factory),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier,
    ) {
        when(val state = uiState) {
            is RecipeDetailsUiState.Loading -> {
                AppLoader()
            }
            is RecipeDetailsUiState.Error -> {
                Text(text = state.message ?: "Unknown error")
            }
            is RecipeDetailsUiState.Empty -> {
                Text(text = state.message ?: "Unknown error")
            }
            is RecipeDetailsUiState.Success -> {
                RecipeDetailsScreen(
                    onSaveClick = viewModel::onSave,
                    recipe = state.recipe
                )
            }
        }
    }
}