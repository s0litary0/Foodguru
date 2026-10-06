package com.example.foodguru.ui.features.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.ScreenLayout

@Composable
fun HomeScreen(
    onRecipeOfTheDayClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier,
    ) {
        when (val state = uiState) {
            is HomeUiState.Loading -> {
                Text(text = "Loading")
            }

            is HomeUiState.Success -> {
                val recipe = state.recipeOfTheDay
                RecipeOfTheDay(
                    recipeId = recipe.id,
                    title = recipe.name,
                    image = recipe.image,
                    type = recipe.mealType,
                    onClick = { onRecipeOfTheDayClick(recipe.id) }
                )
            }
        }
    }


}