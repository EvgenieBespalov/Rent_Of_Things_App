package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.rent_of_things_app.R
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.domain.entity.ProductTypeEntity
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.presentation.ProductTypesUiSate
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
    val state by viewModel.state.observeAsState(ProductListScreenUiState.Initial)
    val stateProductType by viewModel.stateProductType.observeAsState(ProductTypesUiSate.Initial)

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {
        when(stateProductType){
            ProductTypesUiSate.Initial    -> viewModel.getAllProductType()
            ProductTypesUiSate.Loading    -> ScreenLoadind()
            is ProductTypesUiSate.Content -> ProductListTabBar(
                productType = (stateProductType as ProductTypesUiSate.Content).productType
            )
            is ProductTypesUiSate.Error   -> ScreenError(errorText = (stateProductType as ProductTypesUiSate.Error).message.orEmpty())
        }

        when(state){
            ProductListScreenUiState.Initial    -> viewModel.getAllProduct()
            ProductListScreenUiState.Loading    -> ScreenLoadind()
            is ProductListScreenUiState.Content -> ProductListMainScreen(
                productList = (state as ProductListScreenUiState.Content).productList,
                navController = navController
            )
            is ProductListScreenUiState.Error   -> ScreenError(errorText = (state as ProductListScreenUiState.Error).message.orEmpty())
        }

    }
}

@Composable
fun ProductListMainScreen(
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
                color = when (productItem.productAvailable) {
                    true -> yellowActive
                    false -> grey
                },
                shape = RoundedCornerShape(shape10)
            )
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
                text = "${productItem.price} руб./${productItem.timeFrame}",
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
fun ProductListTabBar(productType: ProductTypeEntity){
    val pullOutPanelExtended = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .border(
                width = 1.dp,
                color = grey
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.padding(paddingTabBar)
        ){
            ProductListFilterPanel(productType = productType)
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
fun ProductListFilterPanel(productType: ProductTypeEntity){
    Column(modifier = Modifier
        .height(sizePullOutPanel.value)
    ){
        ProductListProductType(productType = productType)
    }
}

@Composable
fun ProductListProductType(
    productType: ProductTypeEntity,
    viewModel: ProductListScreenViewModel = koinViewModel(),
){
    val selectedOption = remember { mutableStateOf("")}
    //selectedOption.value = null

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        userScrollEnabled = userScrollEnabled.value
    ){
        productType.productName.forEach {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .background(
                            color = when(selectedOption.value){
                                it -> yellowActive
                                else -> grey
                            }
                        )
                        .clickable {
                            if (selectedOption.value == it){
                                selectedOption.value = ""
                                viewModel.getAllProduct()
                            }
                            else{
                                selectedOption.value = it
                                viewModel.getProductsByType(selectedOption.value)
                            }
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = it,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }

            }
        }
    }
}