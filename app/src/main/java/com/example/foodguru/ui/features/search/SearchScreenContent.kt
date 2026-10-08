package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodguru.FoodguruApp
import com.example.foodguru.ui.components.AppSearchBar
import com.example.foodguru.ui.theme.FoodguruTheme


@Composable
fun SearchScreenContent(
    recipes: List<Recipe>,
    tags: List<Tag>,
    selectedTags: List<Tag>,
    toggleTag: (Tag) -> Unit,
    onRecipeClick: (Long) -> Unit,
    textFieldState: TextFieldState,
    searchResults: List<String>,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        AppSearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            textFieldState = textFieldState,
            placeholder = "Search recipes...",
            searchResults = searchResults,
            onSearch = { query ->
                onSearch(query)
            },
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


@Preview(
    showBackground = true
)
@Composable
fun SearchScreenContentPreview() {
    FoodguruTheme {
        SearchScreenContent(
            recipes = getRecipesList(),
            tags = getTags(),
            selectedTags = getTags().filterIndexed { index, tag -> index % 2 == 0 },
            toggleTag = {  },
            onRecipeClick = {   },
            textFieldState = TextFieldState(),
            searchResults = emptyList(),
            onSearch = {  }
        )
    }
}