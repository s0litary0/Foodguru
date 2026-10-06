package com.example.foodguru

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodguru.ui.features.details.RecipeDetailsScreen
import com.example.foodguru.ui.features.home.HomeScreen
import com.example.foodguru.ui.features.search.SearchScreen


@Composable
fun FoodguruNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier,
    ) {
        composable(route = Home.route) {
            HomeScreen(
                onRecipeOfTheDayClick = { recipeId ->
                    navController.navigateToSingleRecipe(recipeId)
                }
            )
        }
        composable(route = Search.route) {
            SearchScreen(
                onRecipeClick = { recipeId ->
                    navController.navigateToSingleRecipe(recipeId)
                }
            )
        }
        composable(route = MyRecipes.route) {

        }
        composable(route = Profile.route) {

        }
        composable(
            route = SingleRecipe.routeWithArgs,
            arguments = SingleRecipe.arguments
        ) { navBackStackEntry ->
//            val recipeId =
//                navBackStackEntry.arguments?.getLong(SingleRecipe.recipeIdArg)
            RecipeDetailsScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route = route) {
        restoreState = true
        launchSingleTop = true
    }

private fun NavHostController.navigateToSingleRecipe(recipeId: Long) {
    this.navigateSingleTopTo(route = "${SingleRecipe.route}/$recipeId")
}