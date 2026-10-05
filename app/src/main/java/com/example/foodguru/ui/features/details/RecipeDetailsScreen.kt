package com.example.foodguru.ui.features.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun RecipeDetailsScreen(
    recipeId: Long?,
    modifier: Modifier = Modifier
) {
    Text(text = "Details $recipeId")
}