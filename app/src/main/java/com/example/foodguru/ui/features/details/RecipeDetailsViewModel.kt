package com.example.foodguru.ui.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodguru.ui.features.search.Recipe
import com.example.foodguru.ui.features.search.getRecipesList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class RecipeDetailsUiState(
    val recipe: Recipe? = null
)

class RecipeDetailsViewModel(val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _recipeId = savedStateHandle.getStateFlow("recipe_id", 1L)
    private val _uiState =
        MutableStateFlow(RecipeDetailsUiState())

    val uiState: StateFlow<RecipeDetailsUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = RecipeDetailsUiState(
            recipe = getRecipeById(_recipeId.value)
        )
    }
}

fun getRecipeById(recipeId: Long): Recipe =
    getRecipesList().find { recipeId == it.id } ?: Recipe(
        id = 1L,
        name = "Classic Margherita Pizza",
        ingredients = listOf(
            "Pizza dough",
            "Tomato sauce",
            "Fresh mozzarella cheese",
            "Fresh basil leaves",
            "Olive oil",
            "Salt and pepper to taste"
        ),
        instructions = listOf(
            "Preheat the oven to 475°F (245°C).",
            "Roll out the pizza dough and spread tomato sauce evenly.",
            "Top with slices of fresh mozzarella and fresh basil leaves.",
            "Drizzle with olive oil and season with salt and pepper.",
            "Bake in the preheated oven for 12-15 minutes or until the crust is golden brown.",
            "Slice and serve hot."
        ),
        prepTimeMinutes = 20L,
        cookTimeMinutes = 15L,
        servings = 4L,
        difficulty = "Easy",
        cuisine = "Italian",
        caloriesPerServing = 300L,
        tags = listOf("Pizza", "Italian"),
        userId = 166L,
        image = "https://cdn.dummyjson.com/recipe-images/1.webp",
        rating = 4.6,
        reviewCount = 98L,
        mealType = listOf("Dinner")
    )