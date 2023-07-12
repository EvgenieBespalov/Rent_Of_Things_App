package com.example.rent_of_things_app.screen

import androidx.compose.foundation.border
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.screen.navigation.Routes
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.yellowActive


@Composable
fun BottomMenuScreen(){
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content = { padding ->
            NavHostContainer(navController = navController, padding = padding)
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        modifier = Modifier
            .border(width = 1.dp, color = grey),
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        ListOfBottomMenuItems.BottomMenuItems.forEach { menuItem ->
            BottomNavigationItem(
                selected = (currentRoute == menuItem.route),
                selectedContentColor = yellowActive,
                unselectedContentColor = grey,
                onClick = {
                    navController.navigate(menuItem.route)
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                label = {
                    Text(
                        text = menuItem.label
                    )
                },
                enabled = true,
                //alwaysShowLabel = false
            )
        }
    }
}

data class BottomMenuItem(val label: String, val icon: ImageVector, var route: String)

object ListOfBottomMenuItems {
    val BottomMenuItems = listOf(
        BottomMenuItem(
            label = "Поиск вещей",
            icon = Icons.Outlined.Search,
            route = Routes.ProductListScreenRoute.route
        ),
        BottomMenuItem(
            label = "Мои вещи",
            icon = Icons.Outlined.ShoppingCart,
            route = Routes.RentalOffersListScreenRoute.route
        ),
        BottomMenuItem(
            label = "Профиль",
            icon = Icons.Outlined.Person,
            route = Routes.ProfileScreenRoute.route
        )
    )
}

@Preview
@Composable
fun MyUITest(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content = { padding ->
            NavHostContainer(navController = navController, padding = padding)
        }
    )

}