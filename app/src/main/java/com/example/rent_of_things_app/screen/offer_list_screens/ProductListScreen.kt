package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.rent_of_things_app.R
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.screen.navigation.Routes
import com.example.rent_of_things_app.screen.offer_list_screens.*
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt


@Composable
fun ProductListScreen(
    viewModel: ProductListScreenViewModel = koinViewModel(),
    navController: NavHostController
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

    val state by viewModel.state.observeAsState(ProductListScreenUiState.Initial)
    //viewModel.getListProduct()

    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {

        when(state){
            ProductListScreenUiState.Initial    -> viewModel.getAllProduct()
            ProductListScreenUiState.Loading    -> ScreenLoadind()
            is ProductListScreenUiState.Content -> ProductListListOfProducts(
                productList = (state as ProductListScreenUiState.Content).productList,
                navController = navController
            )
            is ProductListScreenUiState.Error   -> ScreenError(errorText = (state as ProductListScreenUiState.Error).message.orEmpty())
        }

        Box(
            modifier = Modifier
                .height(toolbarHeight)
                .offset { IntOffset(x = 0, y = toolbarOffsetHeightPx.value.roundToInt()) },
        ){
            ProductListTabBar()
        }
    }
}

@Composable
fun ProductListListOfProducts(
    productList: List<ProductEntity>,
    navController: NavHostController
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        userScrollEnabled = userScrollEnabled.value
    ) {
        productList.forEach {
            item{
                ProductListItemOfList(
                    navController = navController,
                    productItem = it
                )
            }
        }
    }
}

@Composable
fun ProductListItemOfList(
    navController: NavHostController,
    productItem: ProductEntity
){
    val image =
        rememberAsyncImagePainter(productItem.photo)

    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(5.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(shape10)
            }
            .border(
                width = 2.dp,
                color = when(productItem.productAvailable){
                    true -> yellowActive
                    false -> grey
                                    },
                shape = RoundedCornerShape(shape10))
            .clickable {
                navController.navigate(Routes.ProductCardScreenRoute.route + "/${productItem.productId}")
            },
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
                painter = image,
                contentDescription = "Изображение товара"
            )
            Text(
                text = productItem.productName,
                modifier = Modifier
                    .padding(5.dp),
                color = when(productItem.productAvailable){
                    true -> Color.Black
                    false -> grey
                }
            )
            Text(
                text = "${productItem.price} руб./${productItem.price}",
                color = when(productItem.productAvailable){
                    true -> Color.Black
                    false -> grey
                }
            )
            Text(
                text = "${productItem.adType}",
                color = when(productItem.productAvailable){
                    true -> Color.Black
                    false -> grey
                }
            )
        }
    }
}

@Composable
fun ProductListTabBar(){
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
            ProductListFilterPanel()
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
fun ProductListFilterPanel(){
    Box(modifier = Modifier
        .height(sizePullOutPanel.value)
    ){
        //Text("gggggggg")
    }
}

@Preview
@Composable
fun PullOutPanelPreview(){
    ProductListFilterPanel()
}

@Preview
@Composable
fun ScreenListOfRentalOffersPreview(){
    val navController = rememberNavController()
    //ProductListItemOfList(navController = navController, "Name", "1488", "day", true, "rent")
}

@Preview
@Composable
fun TabBarPreview(){
    ProductListTabBar()
}

