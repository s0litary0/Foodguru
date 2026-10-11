package com.example.foodguru.ui.features.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.foodguru.data.source.network.NetworkRecipe
import com.example.foodguru.ui.features.home.components.RecipeOfTheDay


@Composable
fun HomeScreen(
    recipeOfTheDay: NetworkRecipe,
    onRecipeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    RecipeOfTheDay(
        recipeId = recipeOfTheDay.id,
        title = recipeOfTheDay.name,
        image = recipeOfTheDay.image,
        onClick = onRecipeClick,
        modifier = modifier
    )
}