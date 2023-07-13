package com.example.rent_of_things_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.presentation.SignInScreenUiState
import com.example.rent_of_things_app.presentation.SignInScreenViewModel
import com.example.rent_of_things_app.presentation.SignUpScreenUiState
import com.example.rent_of_things_app.presentation.SignUpScreenViewModel
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpScreenViewModel = koinViewModel()
)  {
    val state by viewModel.state.observeAsState(SignUpScreenUiState.Content("ii"))
    when(state){
        SignUpScreenUiState.Initial    -> Unit
        SignUpScreenUiState.Loading    -> ScreenLoadind()
        is SignUpScreenUiState.Content -> Unit
        is SignUpScreenUiState.Error   -> ScreenError(errorText = (state as SignUpScreenUiState.Error).message.orEmpty())
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier
                .padding(vertical = 30.dp),
            text = "Создание профиля",
            fontSize = 25.sp,
            color = greyText
        )

        var userNameTextField by remember { mutableStateOf("") }
        var userMiddleNameTextField by remember { mutableStateOf("") }
        var userSurnameTextField by remember { mutableStateOf("") }
        var userEmailTextField by remember { mutableStateOf("") }
        var userSocialNetworksTextField by remember { mutableStateOf("") }
        var userPasswordTextField by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userNameTextField,
            onValueChange = {
                //if (it.length <= maxChar)
                userNameTextField = it
                            },
            placeholder = {
                Text(
                    "Имя",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userMiddleNameTextField,
            onValueChange = { userMiddleNameTextField = it },
            placeholder = {
                Text(
                    "Отчество",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userSurnameTextField,
            onValueChange = { userSurnameTextField = it },
            placeholder = {
                Text(
                    "Фамилия",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
            value = userEmailTextField,
            onValueChange = { userEmailTextField = it },
            placeholder = {
                Text(
                    "Email",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
            value = userSocialNetworksTextField,
            onValueChange = { userSocialNetworksTextField = it },
            placeholder = {
                Text(
                    "Социальные сети",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
            value = userPasswordTextField,
            onValueChange = { userPasswordTextField = it },
            placeholder = {
                Text(
                    "Пароль",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                disabledBorderColor = grey,
                errorBorderColor = grey,
                leadingIconColor = grey
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        //OutlinedTextFieldSign(Icons.Outlined.AccountCircle, "Имя")
        //OutlinedTextFieldSign(Icons.Outlined.AccountCircle, "Отчество")
        //OutlinedTextFieldSign(Icons.Outlined.AccountCircle, "Фамилия")
        //OutlinedTextFieldSign(Icons.Outlined.Email, "Email")
        //OutlinedTextFieldSign(Icons.Outlined.Person, "Социальные сети")
        //OutlinedTextFieldSign(Icons.Outlined.Lock, "Пароль")

        Button(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(300.dp, 55.dp),
            onClick = {
                      viewModel.registrationUser(
                          UserEntity(
                              id = null,
                              email = userEmailTextField,
                              name = userNameTextField,
                              middleName = userMiddleNameTextField,
                              surname = userSurnameTextField,
                              password = userPasswordTextField,
                              registrationDate = null,
                              admin = false,
                              socialNetworks = listOf(userSocialNetworksTextField)
                          )
                      )
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = yellowActive,
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapeScheme.shape30,
        ){
            Text(
                text = "Регистрация",
                fontSize = fontTextFieldSignScreen
            )
        }


        SignUpScreenRow()
    }
}

@Composable
fun SignUpScreenRow(){
    Row(
        modifier = Modifier.padding(vertical = 20.dp)
    ){
        Text(
            text = "Уже есть аккаунт? ",
            fontSize = 20.sp,
            color = greyText
        )
        Text("Войдите",
            fontSize = 20.sp,
            modifier = Modifier.clickable( onClick = {  }),
            color = yellowActive
        )
    }
}

@Preview
@Composable
fun ScreenSignUpPreview(){
    SignUpScreen()
}