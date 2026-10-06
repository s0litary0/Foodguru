package com.example.foodguru.ui.features.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun RecipeListCard(
    id: Long,
    image: String,
    title: String,
    modifier: Modifier = Modifier,
    tags: List<Tag> = emptyList(),
    onClick: (Long) -> Unit,
) {
    Card(
        modifier = modifier
            .clickable { onClick(id) }
            .height(250.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            AsyncImage(
                model = image,
                contentDescription = title,
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                tags.forEach { tag ->
                    Text(text = tag.label)
                }
            }
        }
    }
}