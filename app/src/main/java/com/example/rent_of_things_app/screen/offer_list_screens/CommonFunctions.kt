package com.example.rent_of_things_app.screen.offer_list_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.shape10

val sizeIconExpand = 20.dp
val sizeSearchLine = 60.dp
val fullSizePullOutPanel = 60.dp
val sizeIconExpandButton = 30.dp
val paddingTabBar = 5.dp

val toolbarHeight = //500.dp
    sizeIconExpand + fullSizePullOutPanel + sizeIconExpandButton + paddingTabBar*4 + sizeSearchLine

var userScrollEnabled =  mutableStateOf(true)
val sizePullOutPanel = mutableStateOf(0.dp)

@Composable
fun ItemOfList(nameThings: String, price: String){
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(5.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(shape10)
            }
            .border(width = 1.dp, color = grey, shape = RoundedCornerShape(shape10)),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier
                    .size(175.dp)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(shape10)
                    },
                painter = ColorPainter(Color.White),
                contentDescription = "Красный прямоугольник"
            )
            Text(
                text = nameThings,
                modifier = Modifier
                    .padding(5.dp)
            )
            Text(
                text = price
            )
        }
    }
}

@Composable
fun ListOfItems(){
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