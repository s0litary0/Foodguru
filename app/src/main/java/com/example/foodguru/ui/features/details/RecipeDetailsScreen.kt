package com.example.foodguru.ui.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.foodguru.R
import com.example.foodguru.ui.components.BackTopAppBar
import com.example.foodguru.ui.components.ScreenLayout
import com.example.foodguru.ui.components.TitleTopAppBar


@Composable
fun RecipeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel : RecipeDetailsViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScreenLayout(
        modifier = modifier,
    ) {
        when(val state = uiState) {
            is RecipeDetailsUiState.Loading -> {
                Text(text = "Loading")
            }
            is RecipeDetailsUiState.Success -> {
                RecipeDetailsScreenContent(
                    onSaveClick = { viewModel.onSave() },
                    recipe = state.recipe
                )
            }
        }
    }
}