package com.example.foodguru

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed interface FoodguruDestination {
    val route: String
}


data object Home : FoodguruDestination {
    override val route = "home"
}


data object Search : FoodguruDestination {
    override val route = "search"
}


data object MyRecipes : FoodguruDestination {
    override val route = "my_recipes"
}


data object Profile : FoodguruDestination {
    override val route = "profile"
}


data object SingleRecipe : FoodguruDestination {
    override val route = "recipes"
    const val recipeIdArg = "recipe_id"
    val routeWithArgs = "$route/{${recipeIdArg}}"
    val arguments = listOf(
        navArgument(recipeIdArg,) { type = NavType.LongType }
    )
}