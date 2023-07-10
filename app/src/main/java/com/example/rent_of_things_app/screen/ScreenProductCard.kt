package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.screen.theme.backgroundGray
import com.example.rent_of_things_app.screen.theme.grey
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
            .background(color = Color.White),
        contentAlignment = Alignment.BottomCenter,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
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
                    painter = ColorPainter(Color.White),
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
                    text = nameProduct
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 25.sp,
                    text = "$priceProduct рублей"
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = addressProduct
                )
            }

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 5.dp),
            ){
                Text(
                    modifier = Modifier
                        .padding(5.dp, 5.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = "Информация о товаре"
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = descriptionProduct
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = dateProduct
                )
                Text(
                    modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp),
                    fontSize = 20.sp,
                    text = statusProduct
                )
            }
        }

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
}

@Preview
@Composable
fun ScreenProductCardPreview(){
    ScreenProductCard()
}