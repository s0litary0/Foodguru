package com.example.foodguru.ui.features.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun RecipeHeader(
    image: String,
    title: String,
    calories: Long,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = image,
            contentDescription = title,
            modifier = Modifier
                .size(128.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "$calories kcal",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}