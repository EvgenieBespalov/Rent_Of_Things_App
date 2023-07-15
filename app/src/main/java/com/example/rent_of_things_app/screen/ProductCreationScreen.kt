package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.presentation.ProductCreationScreenUiState
import com.example.rent_of_things_app.presentation.ProductCreationScreenViewModel
import com.example.rent_of_things_app.screen.navigation.Routes
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductCreationScreen(
    viewModel: ProductCreationScreenViewModel = koinViewModel(),
    navController: NavHostController
){

    val state by viewModel.state.observeAsState(ProductCreationScreenUiState.Initial)
    when(state){
        ProductCreationScreenUiState.Initial    -> Unit
        ProductCreationScreenUiState.Loading    -> ScreenLoadind()
        is ProductCreationScreenUiState.Content -> Unit
        is ProductCreationScreenUiState.Error   -> ScreenError(errorText = (state as ProductCreationScreenUiState.Error).message.orEmpty())
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundGray)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProductCreationMainInfo()
    }
}

@Composable
fun ProductCreationMainInfo(viewModel: ProductCreationScreenViewModel = koinViewModel()){
    var nameProductTextField by remember { mutableStateOf("") }
    var nameProductCorrectTextField by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 20.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = nameProductTextField,
        onValueChange = {
            if (it.length > 0){
                nameProductTextField = it
                nameProductCorrectTextField = true
            }
        },
        isError = nameProductCorrectTextField,
        placeholder = {
            Text(
                "Название товара",
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            errorBorderColor = yellowActive,
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    var priceProductTextField by remember { mutableStateOf("") }
    var priceProductCorrectTextField by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = priceProductTextField,
        onValueChange = {
            if (it.length > 0){
                priceProductTextField = it
                priceProductCorrectTextField = true
            }
        },
        isError = priceProductCorrectTextField,
        placeholder = {
            Text(
                "Цена аренды",
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            errorBorderColor = yellowActive,
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    var descriptionProductTextField by remember { mutableStateOf("") }
    var descriptionProductCorrectTextField by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = descriptionProductTextField,
        onValueChange = {
            if (it.length > 0){
                descriptionProductTextField = it
                descriptionProductCorrectTextField = true
            }
        },
        isError = descriptionProductCorrectTextField,
        placeholder = {
            Text(
                "Описание",
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            errorBorderColor = yellowActive,
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    var adressProductTextField by remember { mutableStateOf("") }
    var adressProductCorrectTextField by remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = adressProductTextField,
        onValueChange = {
            if (it.length > 0){
                adressProductTextField = it
                adressProductCorrectTextField = true
            }
        },
        isError = adressProductCorrectTextField,
        placeholder = {
            Text(
                "Адрес",
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            errorBorderColor = yellowActive,
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    var urlImageProductTextField by remember { mutableStateOf("https://sun9-71.userapi.com/YQ7nGK_Q5xmY_E-1G49yA8Z3dCJA4u54XQ3ciA/NzAdeW8sYHg.jpg") }
    var urlImageProductCorrectTextField by remember { mutableStateOf(true) }
    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        value = urlImageProductTextField,
        onValueChange = {
            if (it.length > 0){
                urlImageProductTextField = it
                urlImageProductCorrectTextField = true
            }
        },
        isError = urlImageProductCorrectTextField,
        placeholder = {
            Text(
                "URL изображения",
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            errorBorderColor = yellowActive,
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    val listProductTypes = listOf("Toys", "Cookware")
    val selectedProductType = remember { mutableStateOf(listProductTypes[0])}
    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp).fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyRow(){
            listProductTypes.forEach {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                            .background(
                                color = when(selectedProductType.value){
                                    it -> yellowActive
                                    else -> grey
                                }
                            )
                            .clickable {
                                selectedProductType.value = it
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = it,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                }
            }
        }
    }

    val adTypeProductTypes = listOf("RENT", "REQUEST")
    val selectedAdTypeProduct = remember { mutableStateOf(adTypeProductTypes[0])}
    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp).fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyRow(){
            adTypeProductTypes.forEach {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                            .background(
                                color = when(selectedAdTypeProduct.value){
                                    it -> yellowActive
                                    else -> grey
                                }
                            )
                            .clickable {
                                selectedAdTypeProduct.value = it
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = it,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                }
            }
        }
    }

    val timeFrameProductTypes = listOf("hour", "day", "week")
    val selectedTimeFrame = remember { mutableStateOf(timeFrameProductTypes[0])}
    Box(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp).fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyRow(){
            timeFrameProductTypes.forEach {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                            .background(
                                color = when(selectedTimeFrame.value){
                                    it -> yellowActive
                                    else -> grey
                                }
                            )
                            .clickable {
                                selectedTimeFrame.value = it
                            },
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxSize(),
                            text = it,
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }

                }
            }
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
            onClick = {
                viewModel.createProduct(
                    ProductEntity(
                        productId = "",
                        userId = null,
                        adType = selectedAdTypeProduct.value,
                        productForRent = true,
                        productName = nameProductTextField,
                        productType = selectedProductType.value,
                        productDescription = descriptionProductTextField,
                        address = adressProductTextField,
                        creationDate = "",
                        photo = urlImageProductTextField,
                        price = priceProductTextField,
                        productAvailable = true,
                        timeFrame = selectedTimeFrame.value
                    ))
            },
            enabled = nameProductCorrectTextField && priceProductCorrectTextField && descriptionProductCorrectTextField && adressProductCorrectTextField && urlImageProductCorrectTextField,
            colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive),
            shape = RoundedCornerShape(shape10)
        ) {
            Text(
                text = "Сохранить",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}
