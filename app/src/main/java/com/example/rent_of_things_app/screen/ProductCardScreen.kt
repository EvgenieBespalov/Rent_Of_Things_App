package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.presentation.ProductCardScreenUiState
import com.example.rent_of_things_app.presentation.ProductCardScreenViewModel
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductCardScreen(
    viewModel: ProductCardScreenViewModel = koinViewModel(),
    productId: String?
){
    val state by viewModel.state.observeAsState(ProductCardScreenUiState.Initial)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(state){
            ProductCardScreenUiState.Initial    -> productId?.let { viewModel.getProduct(it) }
            ProductCardScreenUiState.Loading    -> ScreenLoadind()
            is ProductCardScreenUiState.Content -> ProductCardMainInfo(
                product = (state as ProductCardScreenUiState.Content).product
            )
            is ProductCardScreenUiState.Error   -> ScreenError(errorText = (state as ProductCardScreenUiState.Error).message.orEmpty())
        }

        ProductCardRentButton()
    }
}

@Composable
fun ProductCardRentButton(){
    Box(
        modifier = Modifier
            .background(color = Color.Transparent)
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive),
            shape = RoundedCornerShape(shape10)
        ) {
            Text(
                text = "Арендовать",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ProductCardMainInfo(
    product: ProductEntity
){
    val image =
        rememberAsyncImagePainter(product.photo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 5.dp)
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(400.dp)
                    .padding(10.dp)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(shape10)
                    }
                    .border(1.dp, color = grey, shape = RoundedCornerShape(shape10)),
                painter = image,
                contentDescription = "Фото товара"
            )
        }

        Column(
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 5.dp)
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = product.productName
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 25.sp,
                text = "${product.price} рублей"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = product.address
            )
            if (!product.productForRent){
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = when(product.productAvailable){
                        true -> "Товар сейчас свободен"
                        else -> "Товар сейчас в аренде"
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 5.dp),
        ){
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp),
                fontSize = 20.sp,
                color = greyText,
                text = "Описание товара"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = product.productDescription
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp),
                fontSize = 20.sp,
                color = greyText,
                text = "Дата создания объявления"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = product.creationDate
            )
        }
    }
}

@Preview
@Composable
fun ScreenProductCardPreview(){
   // ProductCardScreen()
}