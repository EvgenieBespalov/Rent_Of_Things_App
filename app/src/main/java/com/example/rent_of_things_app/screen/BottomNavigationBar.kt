package com.example.rent_of_things_app.screen

import androidx.compose.foundation.border
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.yellowActive

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



