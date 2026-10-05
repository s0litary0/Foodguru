package com.example.foodguru.ui.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.foodguru.R


@Composable
fun RecipeDetailsScreen(
    onBackClicked: () -> Unit,
    recipeDetailsViewModel : RecipeDetailsViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by recipeDetailsViewModel.uiState.collectAsStateWithLifecycle()

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        BackTopAppBar(
            title = stringResource(R.string.recipe_details),
            onClick = onBackClicked
        )
        Text(text = uiState.recipe?.name ?: "123")
//        AsyncImage(
//            model = uiState.recipe?.image,
//            contentDescription = uiState.recipe?.name
//        )
    }
}