package com.example.foodguru.ui.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodguru.R


data class Route(val painter: Painter, val label: String, val route: String)

@Composable
fun ScreenLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val routes = listOf<Route>(
        Route(
            painter = painterResource(R.drawable.home_24px),
            label = "Home",
            route="home"
        ),
        Route(
            painter = painterResource(R.drawable.search_24px),
            label = "Search",
            route="search"
        ),
        Route(
            painter = painterResource(R.drawable.bookmark_24px),
            label = "My recipes",
            route="my_recipes"
        ),
        Route(
            painter = painterResource(R.drawable.person_24px),
            label = "Profile",
            route="profile"
        ),

    )
    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(
                modifier = Modifier,
            ) {
                routes.forEachIndexed { index, route ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {},
                        icon = {
                            Icon(
                                painter = route.painter,
                                contentDescription = route.label
                            )
                        },
                        label = {
                            Text(text=route.label)
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