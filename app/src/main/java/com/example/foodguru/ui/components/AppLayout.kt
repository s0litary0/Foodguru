package com.example.foodguru.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.foodguru.R


interface NavBarDestinationScreen {
    val icon: Int
    val iconFilled: Int
    val label: String
    val route: String
}


data object HomeNavScreen : NavBarDestinationScreen {
    override val icon = R.drawable.home_24px
    override val iconFilled = R.drawable.home_filled_24px
    override val label = "Home"
    override val route = "home"
}


data object SearchNavScreen : NavBarDestinationScreen {
    override val icon = R.drawable.search_24px
    override val iconFilled = R.drawable.search_24px
    override val label = "Search"
    override val route = "search"
}


data object MyRecipesNavScreen : NavBarDestinationScreen {
    override val icon = R.drawable.bookmark_24px
    override val iconFilled = R.drawable.bookmark_filled_24px
    override val label = "My Recipes"
    override val route = "my_recipes"
}


data object ProfileNavScreen : NavBarDestinationScreen {
    override val icon = R.drawable.person_24px
    override val iconFilled = R.drawable.person_filled_24px
    override val label = "Profile"
    override val route = "profile"
}

val foodguruBottomNavBarScreens = listOf(
    HomeNavScreen, SearchNavScreen, MyRecipesNavScreen, ProfileNavScreen
)

@Composable
fun AppLayout(
    currentNavScreen: NavBarDestinationScreen,
    onNavBarItemClick: (NavBarDestinationScreen) -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                modifier = Modifier,
            ) {
                foodguruBottomNavBarScreens.forEach { screen ->
                    val selected: Boolean = screen == currentNavScreen
                    NavigationBarItem(
                        selected = selected,
                        onClick = { onNavBarItemClick(screen) },
                        icon = {
                            Icon(
                                painter = painterResource(
                                    id =
                                        if (selected) screen.iconFilled
                                        else screen.icon
                                ),
                                contentDescription = screen.label
                            )
                        },
                        label = {
                            Text(text = screen.label)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            content()
        }
    }
}