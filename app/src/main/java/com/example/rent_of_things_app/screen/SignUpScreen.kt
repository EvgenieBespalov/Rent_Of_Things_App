package com.example.rent_of_things_app.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.presentation.*
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpScreenViewModel = koinViewModel(),
    navController: NavHostController
)  {
    val state by viewModel.state.observeAsState(SignUpScreenUiState.Initial)
    when(state){
        SignUpScreenUiState.Initial    -> Unit
        SignUpScreenUiState.Loading    -> ScreenLoadind()
        is SignUpScreenUiState.Content -> Unit
        is SignUpScreenUiState.Error   -> ScreenError(errorText = (state as SignUpScreenUiState.Error).message.orEmpty())
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
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








        val maxSizeTextField = 30


        var userNameTextField by remember { mutableStateOf("") }
        var userNameCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userNameTextField,
            onValueChange = {
                if (it.length <= maxSizeTextField) userNameTextField = it
                if (it.length > 0 && it.length <= maxSizeTextField) userNameCorrectTextField = true
                else userNameCorrectTextField = false
                            },
            isError = userNameCorrectTextField,
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
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        var userMiddleNameTextField by remember { mutableStateOf("") }
        var userMiddleNameCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userMiddleNameTextField,
            onValueChange = {
                if (it.length <= maxSizeTextField) userMiddleNameTextField = it
                if (it.length > 0 && it.length <= maxSizeTextField) userMiddleNameCorrectTextField = true
                else userMiddleNameCorrectTextField = false
                            },
            isError = userMiddleNameCorrectTextField,
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
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        var userSurnameTextField by remember { mutableStateOf("") }
        var userSurnameCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.AccountCircle, contentDescription = null) },
            value = userSurnameTextField,
            onValueChange = {
                if (it.length <= maxSizeTextField) userSurnameTextField = it
                if (it.length > 0 && it.length <= maxSizeTextField) userSurnameCorrectTextField = true
                else userSurnameCorrectTextField = false
                            },
            isError = userSurnameCorrectTextField,
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
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        var userEmailTextField by remember { mutableStateOf("") }
        var userEmailCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
            value = userEmailTextField,
            onValueChange = {
                if (it.length <= maxSizeTextField)
                    userEmailTextField = it

                if (it.length > 0 && it.length <= maxSizeTextField && android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches())
                    userEmailCorrectTextField = true
                else
                    userEmailCorrectTextField = false
                            },
            isError = userEmailCorrectTextField,
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
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        var userSocialNetworksTextField by remember { mutableStateOf("") }
        var userSocialNetworksCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
            value = userSocialNetworksTextField,
            onValueChange = {
                    userSocialNetworksTextField = it
                    if (it.length > 0) userSocialNetworksCorrectTextField = true
                    else userSocialNetworksCorrectTextField = false
                            },
            isError = userSocialNetworksCorrectTextField,
            placeholder = {
                Text(
                    "Соцсети через пробел",
                    fontSize = fontTextFieldSignScreen
                ) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                placeholderColor = greyText,
                focusedBorderColor = grey,
                unfocusedBorderColor = grey,
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        var userPasswordTextField by remember { mutableStateOf("") }
        var userPasswordCorrectTextField by remember { mutableStateOf(false) }
        OutlinedTextField(
            modifier = Modifier
                .padding(20.dp, 0.dp, 20.dp, 20.dp)
                .height(55.dp)
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
            value = userPasswordTextField,
            onValueChange = {
                if (it.length <= maxSizeTextField) userPasswordTextField = it
                if (it.length > 0 && it.length <= maxSizeTextField) userPasswordCorrectTextField = true
                else userPasswordCorrectTextField = false
                            },
            isError = userPasswordCorrectTextField,
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
                errorBorderColor = yellowActive,
                leadingIconColor = grey,
                errorLeadingIconColor = yellowActive
            ),
            shape = MaterialTheme.shapeScheme.shape30,
            textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

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
                              middleName = when(userMiddleNameTextField){
                                  "" -> null
                                  else -> userMiddleNameTextField
                                                                        },
                              surname = userSurnameTextField,
                              password = userPasswordTextField,
                              registrationDate = null,
                              admin = false,
                              socialNetworks = when(userSocialNetworksTextField){
                                  "" -> null
                                  else -> listOf(*userSocialNetworksTextField.split(" ").toTypedArray())
                              }
                          )
                      )
            },
            enabled = userNameCorrectTextField && userSurnameCorrectTextField && userEmailCorrectTextField && userPasswordCorrectTextField,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = yellowActive,
                contentColor = Color.White,
                disabledBackgroundColor = yellowInactive
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
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}