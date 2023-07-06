package com.example.rent_of_things_app.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.screen.theme.ScreenSignIn
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.yellowActive

@Composable
fun MyUI(navController: NavHostController) {
    /*val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SignInScreenRoute.route) {
        composable(Routes.SignInScreenRoute.route) {
            ScreenSignIn()
        }
        composable(Routes.SignUpScreenRoute.route) {
            ScreenSignUp()
        }
    }*/

    //val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext

    var selectedItem by remember { mutableStateOf("Поиск вещей") }

//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(color = Color.Yellow),
//    ) {

        BottomNavigation(
            modifier = Modifier
                //.align(alignment = Alignment.BottomCenter)
                .border(width = 1.dp, color = grey),
            backgroundColor = Color.White
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route


            Constants.BottomMenuItems.forEach { menuItem ->
                BottomNavigationItem(
                    selected = (currentRoute == menuItem.route),
                    //selected = (selectedItem == menuItem.label),
                    selectedContentColor = yellowActive,
                    unselectedContentColor = grey,
                    onClick = {
                        navController.navigate(menuItem.route)
                        /*selectedItem = menuItem.label
                        Toast.makeText(
                            contextForToast,
                            menuItem.label,
                            Toast.LENGTH_SHORT
                        ).show()*/
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
                    alwaysShowLabel = false
                )
            }
        }
    //}
}

@Preview
@Composable
fun MyUITest(){
    val navController = rememberNavController()
    Scaffold(
        // Bottom navigation
        bottomBar = {
            MyUI(navController = navController)
        },
        content = { padding ->
            // Navhost: where screens are placed
            NavHostContainer(navController = navController, padding = padding)
        }
    )

}

/*private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

    bottomMenuItemsList.add(BottomMenuItem(label = "Поиск вещей", icon = Icons.Outlined.Search, { ScreenSignIn()}))
    bottomMenuItemsList.add(BottomMenuItem(label = "Мои вещи", icon = Icons.Outlined.ShoppingCart, { ScreenSignIn()}))
    bottomMenuItemsList.add(BottomMenuItem(label = "Профиль", icon = Icons.Outlined.Person, { ScreenSignUp()}))


    return bottomMenuItemsList
}*/

object Constants {
    val BottomMenuItems = listOf(
        BottomMenuItem(
            label = "Поиск вещей",
            icon = Icons.Outlined.Search,
            route = "search"
        ),
        BottomMenuItem(
            label = "Мои вещи",
            icon = Icons.Outlined.ShoppingCart,
            route = "search"
        ),
        BottomMenuItem(
            label = "Профиль",
            icon = Icons.Outlined.Person,
            route = "profile"
        )
    )
}

//typealias ComposableFun = @Composable () -> Unit

data class BottomMenuItem(val label: String, val icon: ImageVector, var route: String)


@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "search",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            // route : Home
            composable("search") {
                ScreenSignIn()
            }


            // route : profile
            composable("profile") {
                ScreenSignUp()
            }
        })

}
