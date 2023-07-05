package com.example.rent_of_things_app.screen

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.yellowActive
import kotlinx.coroutines.launch

@Composable
fun MyUI() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext

    var selectedItem by remember { mutableStateOf("Поиск вещей") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Yellow),
    ) {

        BottomNavigation(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .border(width = 1.dp, color = grey),
            backgroundColor = Color.White
        ) {
            bottomMenuItemsList.forEach { menuItem ->
                BottomNavigationItem(
                    selected = (selectedItem == menuItem.label),
                    selectedContentColor = yellowActive,
                    unselectedContentColor = grey,
                    onClick = {
                        selectedItem = menuItem.label
                        Toast.makeText(
                            contextForToast,
                            menuItem.label,
                            Toast.LENGTH_SHORT
                        ).show()
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
                    enabled = true
                )
            }
        }
    }
}

@Preview
@Composable
fun MyUITest(){
    MyUI()
}

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

    bottomMenuItemsList.add(BottomMenuItem(label = "Поиск вещей", icon = Icons.Outlined.Search))
    bottomMenuItemsList.add(BottomMenuItem(label = "Мои вещи", icon = Icons.Outlined.ShoppingCart))
    bottomMenuItemsList.add(BottomMenuItem(label = "Профиль", icon = Icons.Outlined.Person))


    return bottomMenuItemsList
}

data class BottomMenuItem(val label: String, val icon: ImageVector)

