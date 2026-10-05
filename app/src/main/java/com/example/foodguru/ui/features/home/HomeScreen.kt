package com.example.foodguru.ui.features.home

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.R
import com.example.foodguru.ui.components.RecipeOfTheDay
import com.example.foodguru.ui.components.ScreenLayout
import com.example.foodguru.ui.components.TitleTopAppBar

@Composable
fun HomeScreen(
    onRecipeOfTheDayClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier,
        topBar = {
            TitleTopAppBar(
                title = stringResource(R.string.home_screen_title),
                modifier = Modifier
            )
        }
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