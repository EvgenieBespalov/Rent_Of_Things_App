package com.example.rent_of_things_app.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomMenuItem(val label: String, val icon: ImageVector, var route: String)

object ListOfBottomMenuItems {
    val BottomMenuItems = listOf(
        BottomMenuItem(
            label = "Поиск вещей",
            icon = Icons.Outlined.Search,
            route = "list_rental_offers"
        ),
        BottomMenuItem(
            label = "Мои вещи",
            icon = Icons.Outlined.ShoppingCart,
            route = "list_rental_offers"
        ),
        BottomMenuItem(
            label = "Профиль",
            icon = Icons.Outlined.Person,
            route = "profile"
        )
    )
}