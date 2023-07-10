package com.example.rent_of_things_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rent_of_things_app.screen.theme.shape10
import com.example.rent_of_things_app.screen.theme.yellowActive

@Composable
fun ScreenProductCard(){
    val nameProduct = "Name product"
    val priceProduct = "Price product"
    val addressProduct = "Address product"

    val descriptionProduct = "Description product"
    val dateProduct = "Date product"
    val statusProduct = "Status product"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
        contentAlignment = Alignment.BottomCenter,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 5.dp)
                    .background(color = Color.Red)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(400.dp)
                        .padding(5.dp),
                    painter = ColorPainter(Color.White),
                    contentDescription = "Красный прямоугольник"
                )
            }

            Column(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 5.dp)
                    .background(color = Color.Red)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = nameProduct
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = priceProduct
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = addressProduct
                )
            }

            Column(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .fillMaxWidth()
            ){
                Text(text = "Информация о товаре")
                Text(text = descriptionProduct)
                Text(text = dateProduct)
                Text(text = statusProduct)
            }
        }

        Box(
            modifier = Modifier
                .background(color = Color.Cyan)
        ){
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive)
            ) {
                Text(
                    text = "Арендовать",
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun ScreenProductCardPreview(){
    ScreenProductCard()
}