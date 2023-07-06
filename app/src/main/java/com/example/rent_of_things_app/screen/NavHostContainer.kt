package com.example.rent_of_things_app.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rent_of_things_app.screen.theme.ScreenSignIn

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "search",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {

            composable("search") {
                ScreenSignIn()
            }

            composable("profile") {
                ScreenSignUp()
            }
        })

}