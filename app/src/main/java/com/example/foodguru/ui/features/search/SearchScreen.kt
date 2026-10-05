package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.AppSearchBar
import com.example.foodguru.ui.components.RecipeListCard

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        AppSearchBar(
            TextFieldState(""),
            onSearch = {},
            searchResults = emptyList()
        )
        Column {
            Text(text = "Tags")
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                items(searchViewModel.tags) { tag ->
                    FilterChip(
                        selected = searchViewModel.isTagSelected(tag),
                        onClick = {
                            searchViewModel.toggleTag(tag)
                        },
                        label = {
                            Text(text = tag.label)
                        }
                    )
                }
            }
        }
        LazyVerticalGrid(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            columns = GridCells.Adaptive(minSize = 128.dp),
            modifier = Modifier
        ) {
            items(searchViewModel.recipes) { recipe ->
                RecipeListCard(
                    image = recipe.image,
                    title = recipe.name,
//                    tags = recipe.tags.map { label -> Tag(label = label)},
                    onClick = {}
                )
            }
        }
    }
}