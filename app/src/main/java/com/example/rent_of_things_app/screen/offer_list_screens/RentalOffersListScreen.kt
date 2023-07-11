package com.example.rent_of_things_app.screen.offer_list_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.screen.theme.shape10
import com.example.rent_of_things_app.screen.theme.yellowActive

@Composable
fun RentalOffersListScreen(){
    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(){
            RentalOffersListButtonAddOffer()
            RentalOffersListListOffers()
        }
    }
}

@Composable
fun RentalOffersListListOffers(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        userScrollEnabled = userScrollEnabled.value
    ) {
        items(100) { index ->
            ItemOfList(
                nameThings = "Name $index",
                price = "Price $index"
            )
        }
    }
}

@Composable
fun RentalOffersListButtonAddOffer(){
    Button(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .size(50.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(shape10)
            },
        colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive),
        onClick = {

        }
    ){
        Text(
            text = "Создать объявление",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun ScreenListOfMyOffersPreview(){
    RentalOffersListScreen()
}