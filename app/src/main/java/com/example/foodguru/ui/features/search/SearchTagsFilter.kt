package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.foodguru.R


@Composable
fun SearchTagsFilter(
    tags: List<Tag>,
    selectedTags: List<Tag>,
    toggleTag: (Tag) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.tags),
            style = MaterialTheme.typography.labelLarge
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ) {
            items(tags) { tag ->
                FilterChip(
                    selected = tag in selectedTags,
                    onClick = {
                        toggleTag(tag)
                    },
                    label = {
                        Text(text = tag.label)
                    }
                )
            }
        }
    }
}