package com.example.foodguru.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodguru.ui.components.AppSearchBar
import com.example.foodguru.ui.components.MealCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        HomeTopAppBar(
            textFieldState = homeViewModel.textFieldState,
            onSearch = { homeViewModel.search() },
            searchResults = emptyList(),
        )

        MealCard(
            meal = homeViewModel.randomMeal,
        )
    }

}