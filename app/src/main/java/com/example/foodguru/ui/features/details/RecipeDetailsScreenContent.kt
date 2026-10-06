package com.example.foodguru.ui.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import com.example.foodguru.R
import com.example.foodguru.ui.features.search.Recipe


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeDetailsScreenContent(
    onSaveClick: () -> Unit,
    recipe: Recipe,
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