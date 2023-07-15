package com.example.rent_of_things_app.screen.offer_list_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.presentation.RentalOffersListScreenUiState
import com.example.rent_of_things_app.presentation.RentalOffersListScreenViewModel
import com.example.rent_of_things_app.screen.ScreenError
import com.example.rent_of_things_app.screen.ScreenLoadind
import com.example.rent_of_things_app.screen.navigation.Routes
import com.example.rent_of_things_app.screen.theme.grey
import com.example.rent_of_things_app.screen.theme.shape10
import com.example.rent_of_things_app.screen.theme.yellowActive
import org.koin.androidx.compose.koinViewModel

@Composable
fun RentalOffersListScreen(
    viewModel: RentalOffersListScreenViewModel = koinViewModel(),
    navController: NavHostController
){
    val state by viewModel.state.observeAsState(RentalOffersListScreenUiState.Initial)

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(state){
            RentalOffersListScreenUiState.Initial    -> viewModel.getRentalOffersList()
            RentalOffersListScreenUiState.Loading    -> ScreenLoadind()
            is RentalOffersListScreenUiState.Content -> {
                when((state as RentalOffersListScreenUiState.Content).userId){
                    null -> Unit
                    else -> RentalOffersListButtonAddOffer(navController =  navController)
                }
                when((state as RentalOffersListScreenUiState.Content).listRentalOffers){
                    null -> Unit
                    else -> (state as RentalOffersListScreenUiState.Content).listRentalOffers?.let {
                        RentalOffersListMainScreen(
                            navController =  navController,
                            it
                        )
                    }
                }
            }
            is RentalOffersListScreenUiState.Error -> when((state as RentalOffersListScreenUiState.Content).userId){
                null -> Unit
                else -> RentalOffersListButtonAddOffer(navController =  navController)
            }
        }
    }
}

@Composable
fun RentalOffersListMainScreen(
    navController: NavHostController,
    listOfRentalOffers: List<ProductEntity>
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        userScrollEnabled = userScrollEnabled.value
    ) {
        listOfRentalOffers.forEach {
            item {
                RentalOffersItemOfList(
                    navController = navController,
                    productItem = it
                )
            }
        }
    }
}

@Composable
fun RentalOffersItemOfList(
    navController: NavHostController,
    productItem: ProductEntity
)
{
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
fun RentalOffersListButtonAddOffer(navController: NavHostController){
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
            navController.navigate(Routes.ProductCreationScreenRoute.route)
        }
    ){
        Text(
            text = "Создать объявление",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}