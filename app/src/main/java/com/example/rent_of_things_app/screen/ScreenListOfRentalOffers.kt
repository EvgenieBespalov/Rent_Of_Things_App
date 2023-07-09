package com.example.rent_of_things_app.screen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.R
import com.example.rent_of_things_app.screen.theme.*
import kotlin.math.roundToInt

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
fun ScreenListOfRentalOffers(){
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
        ListOfItems()
        Box(
            modifier = Modifier
                .height(toolbarHeight)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
        ){
            TabBar()
        }
    }
}

@Composable
fun TabBar(){
    val pullOutPanelExtended = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .padding(paddingTabBar)
        ){
            SearchBarThings()
            PullOutPanel()
            IconButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sizeIconExpandButton)//.background(Color.Red)
                ,
                onClick = {
                    when(pullOutPanelExtended.value){
                        false -> {
                            sizePullOutPanel.value = fullSizePullOutPanel
                            pullOutPanelExtended.value = true
                            userScrollEnabled.value = false
                        }
                        true -> {
                            sizePullOutPanel.value = 0.dp
                            pullOutPanelExtended.value = false
                            userScrollEnabled.value = true
                        }
                    }
                }
            ) {
                Icon(
                    painterResource(
                        id = when(pullOutPanelExtended.value){
                            true -> R.drawable.icon_expand_less
                            false -> R.drawable.icon_expand_more
                        }
                    ),
                    modifier = Modifier
                        .height(sizeIconExpand)//.background(Color.Blue)
                    ,
                    contentDescription = null,
                    tint = yellowActive
                )
            }
        }
    }
}

@Composable
fun PullOutPanel(){
    Box(modifier = Modifier
        //.height(sizePullOutPanel.value)//.background(Color.Yellow)
        .height(50.dp)//.background(Color.Yellow)
    ){
        //Text("gggggggg")
    }
}

@Preview
@Composable
fun PullOutPanelPreview(){
    PullOutPanel()
}

@Composable
fun SearchBarThings(){
    var textField by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(sizeSearchLine)
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

@Preview
@Composable
fun ScreenListOfRentalOffersPreview(){
    ScreenListOfRentalOffers()
}

@Preview
@Composable
fun TabBarPreview(){
    TabBar()
}
