package com.example.foodguru.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.example.foodguru.ui.features.search.Tag


@Composable
fun RecipeListCard(
    image: String,
    title: String,
    modifier: Modifier = Modifier,
    tags: List<Tag> = emptyList(),
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clickable { onClick }
    ) {
        Column(
            modifier = Modifier
        ) {
            AsyncImage(
                model = image,
                contentDescription = title,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = title)
            tags.forEach { tag ->
                Text(text = tag.label)
            }
        }
    }
}