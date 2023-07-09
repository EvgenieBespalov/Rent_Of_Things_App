package com.example.rent_of_things_app.screen.offer_list_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.screen.theme.shape10
import com.example.rent_of_things_app.screen.theme.yellowActive

@Composable
fun ScreenListOfMyOffers(){
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
    var textField by remember { mutableStateOf("") }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {

                val delta = available.y
                val newOffset = toolbarOffsetHeightPx.value + delta
                toolbarOffsetHeightPx.value = newOffset.coerceIn(-toolbarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(){
            ButtonToAddNewOffer()
            ListOfItems()

        }


    }
}

@Preview
@Composable
fun ScreenListOfMyOffersPreview(){
    ScreenListOfMyOffers()
}

@Composable
fun ButtonToAddNewOffer(){
    IconButton(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .size(50.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(shape10)
            }
            .background(color = yellowActive),
        onClick = {

        }
    ){
        Icon(
            Icons.Outlined.Add,
            "Создать объявление",
            tint = Color.White,
            modifier = Modifier.fillMaxSize()
        )
    }
}