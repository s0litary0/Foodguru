package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodguru.ui.components.AppSearchBar


@Composable
fun SearchScreenContent(
    recipes: List<Recipe>,
    tags: List<Tag>,
    selectedTags: List<Tag>,
    toggleTag: (Tag) -> Unit,
    onRecipeClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        AppSearchBar(
            TextFieldState(""),
            onSearch = {},
            searchResults = emptyList()
        )
        SearchTagsFilter(
            tags = tags,
            selectedTags = selectedTags,
            toggleTag = toggleTag
        )
        RecipeList(
            recipes = recipes,
            onRecipeClick = onRecipeClick
        )
    }
}