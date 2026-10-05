package com.example.foodguru.ui.features.home


import androidx.lifecycle.ViewModel
import com.example.foodguru.ui.features.details.getRecipeById
import com.example.foodguru.ui.features.search.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



sealed class HomeUiState {
    data class Success(val recipeOfTheDay: Recipe) : HomeUiState()
    data object Loading : HomeUiState()
}


class HomeViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<HomeUiState> =
        MutableStateFlow(
            HomeUiState.Loading
        )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


    init {
        _uiState.value = HomeUiState.Success(getRecipeById(1))
    }
}
