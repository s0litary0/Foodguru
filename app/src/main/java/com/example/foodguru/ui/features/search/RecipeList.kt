package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodguru.R


@Composable
fun RecipeList(
    recipes: List<Recipe>,
    onRecipeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    if (recipes.isEmpty()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(R.string.no_recipes_found),
                style = MaterialTheme.typography.headlineLarge
            )
        }
    } else {
        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Adaptive(minSize = 128.dp),
            modifier = modifier
        ) {
            items(recipes) { recipe ->
                RecipeListCard(
                    id = recipe.id,
                    image = recipe.image,
                    title = recipe.name,
                    onClick = { recipeId -> onRecipeClick(recipeId) }
                )
            }
        }
    }
}