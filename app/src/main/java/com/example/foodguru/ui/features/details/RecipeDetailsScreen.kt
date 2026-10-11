package com.example.foodguru.ui.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.foodguru.data.source.network.NetworkRecipe
import com.example.foodguru.ui.features.details.components.RecipeHeader
import com.example.foodguru.ui.features.details.components.RecipeIngredients
import com.example.foodguru.ui.features.details.components.RecipeInstructions
import com.example.foodguru.ui.features.details.components.RecipeSave
import com.example.foodguru.ui.features.search.Recipe


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreen(
    onSaveClick: () -> Unit,
    recipe: NetworkRecipe,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            RecipeHeader(
                image = recipe.image,
                title = recipe.name,
                calories = recipe.caloriesPerServing
            )
            RecipeIngredients(
                ingredients = recipe.ingredients
            )
            RecipeInstructions(
                instructions = recipe.instructions
            )
        }
        RecipeSave(
            onSaveClick = onSaveClick
        )
    }
}


//@Preview(
//    showBackground = true,
//)
//@Composable
//fun RecipeDetailsScreenPreview() {
//    FoodguruTheme {
//        RecipeDetailsScreenContent(
//            onSaveClick = {   },
//            recipe = getRecipeById(1L)
//        )
//    }
//}