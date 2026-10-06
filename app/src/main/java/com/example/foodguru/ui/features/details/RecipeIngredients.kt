package com.example.foodguru.ui.features.details

import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodguru.R


@Composable
fun RecipeIngredients(
    ingredients: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.ingredients),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            ingredients.forEachIndexed { index, ingredient ->
                Text(
                    text = "${index + 1}. $ingredient",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}