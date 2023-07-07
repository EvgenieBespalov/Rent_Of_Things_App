package com.example.rent_of_things_app.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.screen.theme.*
import kotlin.math.roundToInt


@Composable
fun ScreenListOfRentalOffersTwo(content: @Composable BoxScope.() -> Unit){
    val toolbarHeight = 60.dp
    var textField by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ){
            OutlinedTextField(
                modifier = Modifier
                    .height(toolbarHeight)
                    .fillMaxWidth()
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(shape10)
                    },
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { Log.d("Click", "IconExample")}) {
                        Icon(Icons.Outlined.Menu, contentDescription = null)
                    }
                               },
                value = textField,
                onValueChange = { textField = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White,
                    placeholderColor = greyText,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    disabledBorderColor = Color.Black,
                    errorBorderColor = Color.Black,
                    leadingIconColor = grey,
                    trailingIconColor = yellowActive
                ),
                shape = MaterialTheme.shapeScheme.shape10,
                textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            )
        }

        Box(content = content)
    }
}

@Preview
@Composable
fun ScreenListOfRentalOffersPreview(){
    ScreenListOfRentalOffersTwo(){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(100) { index ->
                ItemOfList(
                    nameThings = "Name $index",
                    price = "Price $index"
                )
            }
        }
    }
}

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

/*

@Composable
fun ScreenListOfRentalOffersTwo(content: @Composable BoxScope.() -> Unit){

    val toolbarHeight = 60.dp
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
        Box(content = content)

        OutlinedTextField(
            modifier = Modifier
                .height(toolbarHeight)
                .fillMaxWidth()
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) }
                .padding(5.dp)
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(shape10)
                },
            value = textField,
            onValueChange = { textField = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = yellowActive,
                unfocusedBorderColor = yellowInactive,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape10,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        )

        /*TopAppBar(
            modifier = Modifier
                .height(toolbarHeight)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) }
                .graphicsLayer {
                    clip = true
                    shape = RoundedCornerShape(shape30)
                }
                .border(width = 1.dp, color = grey, shape = RoundedCornerShape(shape30)),
            backgroundColor = Color.White
        ){
            Text("Hello World", fontSize = 28.sp)
        }*/
    }
}

@Preview
@Composable
fun ScreenListOfRentalOffersPreview(){
    ScreenListOfRentalOffersTwo(){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(100) { index ->
                ItemOfList(
                    nameThings = "Name $index",
                    price = "Price $index"
                )
            }
        }
    }

    /*LazyColumn(contentPadding = PaddingValues(top = toolbarHeight)) {
            items(100) { index ->
                Text("I'm item $index", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }*/
}

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
                painter = ColorPainter(Color.Red),
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
}*/