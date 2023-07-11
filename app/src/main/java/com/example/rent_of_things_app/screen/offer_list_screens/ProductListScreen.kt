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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.R
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.screen.offer_list_screens.*
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt


@Composable
fun ProductListScreen(
    viewModel: ProductListScreenViewModel = koinViewModel()
){
    val toolbarHeightPx = with(LocalDensity.current) { toolbarHeight.roundToPx().toFloat() }
    val toolbarOffsetHeightPx = remember { mutableStateOf(0f) }
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

    val state by viewModel.state.observeAsState(ProductListScreenUiState.Content("ii"))
    //viewModel.getListProduct()

    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {

        when(state){
            ProductListScreenUiState.Initial    -> viewModel.getListProduct()
            ProductListScreenUiState.Loading    -> ScreenLoadind()
            is ProductListScreenUiState.Content -> ProductListListOfProducts()
            is ProductListScreenUiState.Error   -> ScreenError(errorText = (state as ProductListScreenUiState.Error).message.orEmpty())
        }

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
fun ProductListListOfProducts(){
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
fun TabBar(){
    val pullOutPanelExtended = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.padding(paddingTabBar)
        ){
            //SearchBarThings()
            PullOutPanel()
            IconButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(sizeIconExpandButton),
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
                    modifier = Modifier.height(sizeIconExpand),
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
        .height(sizePullOutPanel.value)
    ){
        //Text("gggggggg")
    }
}

@Preview
@Composable
fun PullOutPanelPreview(){
    PullOutPanel()
}

@Preview
@Composable
fun ScreenListOfRentalOffersPreview(){
    ProductListScreen()
}

@Preview
@Composable
fun TabBarPreview(){
    TabBar()
}

