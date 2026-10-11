package com.example.foodguru.ui.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodguru.data.source.network.NetworkRecipe
import com.example.foodguru.ui.components.AppSearchBar
import com.example.foodguru.ui.features.search.components.RecipeList
import com.example.foodguru.ui.features.search.components.SearchTagsFilter
import com.example.foodguru.ui.theme.FoodguruTheme


@Composable
fun SearchScreen(
    recipes: List<NetworkRecipe>,
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        AppSearchBar(
            modifier = Modifier,
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


//@Preview(
//    showBackground = true
//)
//@Composable
//fun SearchScreenPreview() {
//    FoodguruTheme {
//        SearchScreen(
//            recipes = getRecipesList(),
//            tags = getTags(),
//            selectedTags = getTags().filterIndexed { index, tag -> index % 2 == 0 },
//            toggleTag = {  },
//            onRecipeClick = {   },
//            textFieldState = TextFieldState(),
//            searchResults = emptyList(),
//            onSearch = {  }
//        )
//    }
//}