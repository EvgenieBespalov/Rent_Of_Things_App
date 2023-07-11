package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.presentation.ProductCreationScreenUiState
import com.example.rent_of_things_app.presentation.ProductCreationScreenViewModel
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProductCreationScreen(
    viewModel: ProductCreationScreenViewModel = koinViewModel()
){

    val state by viewModel.state.observeAsState(ProductCreationScreenUiState.Content("ii"))
    when(state){
        ProductCreationScreenUiState.Initial    -> Unit
        ProductCreationScreenUiState.Loading    -> ScreenLoadind()
        is ProductCreationScreenUiState.Content -> Unit
        is ProductCreationScreenUiState.Error   -> ScreenError(errorText = (state as ProductListScreenUiState.Error).message.orEmpty())
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.BottomCenter,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = backgroundGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProductCreationAddImageButton()
            //ProductCreationImage()
            ProductCreationMainInfo()
        }
        ProductCreationSaveButton()
    }
}

@Composable
fun ProductCreationSaveButton(){
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
                text = "Сохранить",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ProductCreationAddImageButton(){
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
                text = "Добавить фото",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ProductCreationMainInfo(){
    Column(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 5.dp)
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        ProductCreationInfoTextField(placeholderText = "Наименование товара")
        ProductCreationInfoTextField(placeholderText = "Цена товара")
        ProductCreationInfoTextField(placeholderText = "Описание товара")
    }
}

@Composable
fun ProductCreationInfoTextField(placeholderText: String){
    var textField by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
            .fillMaxWidth(),
        value = textField,
        onValueChange = { textField = it },
        placeholder = {
            Text(
                placeholderText,
                fontSize = fontTextFieldSignScreen
            ) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White,
            placeholderColor = greyText,
            focusedBorderColor = yellowActive,
            unfocusedBorderColor = yellowActive,
            disabledBorderColor = yellowActive,
            errorBorderColor = yellowActive,
            leadingIconColor = grey
        ),
        shape = MaterialTheme.shapeScheme.shape10,
        textStyle = TextStyle(fontSize = 20.sp),
    )
}

@Preview
@Composable
fun ScreenProductCreationPreview(){
    ProductCreationScreen()
}

@Composable
fun ProductCreationImage(){
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
}