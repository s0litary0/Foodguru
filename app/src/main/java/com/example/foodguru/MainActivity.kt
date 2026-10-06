package com.example.foodguru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodguru.ui.components.HomeNavScreen
import com.example.foodguru.ui.components.AppLayout
import com.example.foodguru.ui.components.BackTopAppBar
import com.example.foodguru.ui.components.MyRecipesNavScreen
import com.example.foodguru.ui.components.ProfileNavScreen
import com.example.foodguru.ui.components.SearchNavScreen
import com.example.foodguru.ui.components.TitleTopAppBar
import com.example.foodguru.ui.components.foodguruBottomNavBarScreens
import com.example.foodguru.ui.features.home.HomeScreen
import com.example.foodguru.ui.theme.FoodguruTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodguruApp()
        }
    }
}


@Composable
fun FoodguruApp() {
    FoodguruTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentNavScreen = foodguruBottomNavBarScreens.find { screen ->
            currentDestination?.route == screen.route
        } ?: SearchNavScreen

        AppLayout(
            topBar = {
                when (currentDestination?.route) {
                    HomeNavScreen.route -> {
                        TitleTopAppBar(
                            title = HomeNavScreen.label,
                            navigationIcon = {
                                IconButton(
                                    onClick = {}
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.settings_32px),
                                        contentDescription = stringResource(R.string.settings)
                                    )
                                }
                            }
                        )
                    }
                    SearchNavScreen.route -> {
                        TitleTopAppBar(title = SearchNavScreen.label)
                    }
                    MyRecipesNavScreen.route -> {
                        TitleTopAppBar(title = MyRecipesNavScreen.label)
                    }
                    ProfileNavScreen.route -> {
                        TitleTopAppBar(title = ProfileNavScreen.label)
                    }
                    SingleRecipe.routeWithArgs -> {
                        BackTopAppBar(
                            title = SingleRecipe.label,
                            onBackClicked = { navController.popBackStack() }
                        )
                    }
                }
            },
            currentNavScreen = currentNavScreen,
            onNavBarItemClick = { newNavScreen ->
                navController.navigateSingleTopTo(newNavScreen.route)
            }
        ) {
            FoodguruNavHost(
                navController = navController,
            )
        }
    }
}