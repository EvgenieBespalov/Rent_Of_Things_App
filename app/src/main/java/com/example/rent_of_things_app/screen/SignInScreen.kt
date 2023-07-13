package com.example.rent_of_things_app.screen.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.presentation.ProductListScreenUiState
import com.example.rent_of_things_app.presentation.ProductListScreenViewModel
import com.example.rent_of_things_app.presentation.SignInScreenUiState
import com.example.rent_of_things_app.presentation.SignInScreenViewModel
import com.example.rent_of_things_app.screen.ProductListListOfProducts
import com.example.rent_of_things_app.screen.ScreenError
import com.example.rent_of_things_app.screen.ScreenLoadind
import com.example.rent_of_things_app.screen.navigation.Routes
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    viewModel: SignInScreenViewModel = koinViewModel(),
    navController: NavHostController
) {
    var textFieldEmail by remember { mutableStateOf("") }
    var textFieldPassword by remember { mutableStateOf("") }

    val state by viewModel.state.observeAsState(SignInScreenUiState.Content("ii"))
    when(state){
        SignInScreenUiState.Initial    -> Unit
        SignInScreenUiState.Loading    -> ScreenLoadind()
        is SignInScreenUiState.Content -> Unit
        is SignInScreenUiState.Error   -> ScreenError(errorText = (state as SignInScreenUiState.Error).message.orEmpty())
    }

    Box(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .graphicsLayer {
                    clip = true
                    shape = AbsoluteCutCornerShape(0.dp, 0.dp, 50.dp, 50.dp)
                }
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ){
            Text(
                modifier = Modifier
                    .rotate(-30f)
                    .padding(bottom = 40.dp),
                text = "StudProkat",
                fontSize = 60.sp,
                color = Color.White,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(300.dp))
            Box(
                modifier = Modifier
                    .size(340.dp, 330.dp)
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(15.dp)
                    }
                    .background(Color.White)
                    .border(width = 1.dp, color = grey, shape = RoundedCornerShape(15.dp))
            ){
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        modifier = Modifier
                            .padding(vertical = 30.dp),
                        text = "Вход в профиль",
                        fontSize = 25.sp,
                        color = greyText
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .size(300.dp, 55.dp),
                        leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
                        value = textFieldEmail,
                        onValueChange = { textFieldEmail = it },
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
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .size(300.dp, 55.dp),
                        leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                        value = textFieldPassword,
                        onValueChange = { textFieldPassword = it },
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
                    )


                    Button(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .size(300.dp, 55.dp),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = yellowActive,
                            contentColor = Color.White
                        ),
                        shape = MaterialTheme.shapeScheme.shape30,
                    ){
                        Text(
                            text = "Вход",
                            fontSize = fontTextFieldSignScreen
                        )
                    }
                }
            }


        }
    }
}

@Composable
fun OutlinedTextFieldSign(
    icon: ImageVector,
    placeholderText: String
){
    var textField by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .padding(20.dp, 0.dp, 20.dp, 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        leadingIcon = { Icon(icon, contentDescription = null) },
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
            focusedBorderColor = grey,
            unfocusedBorderColor = grey,
            disabledBorderColor = grey,
            errorBorderColor = grey,
            leadingIconColor = grey
        ),
        shape = MaterialTheme.shapeScheme.shape30,
        textStyle = TextStyle(fontSize = fontTextFieldSignScreen),
    )
}

@Composable
fun SignInScreenRow(navController: NavHostController){
    Row(
        modifier = Modifier.padding(vertical = 20.dp)
    ){
        Text(
            text = "Нет аккаунта? ",
            fontSize = 20.sp,
            color = greyText
        )
        Text("Зарегистрируйтесь",
            fontSize = 20.sp,
            modifier = Modifier.clickable( onClick = {
                navController.navigate(Routes.SignUpScreenRoute.route)
            }),
            color = yellowActive
        )
    }
}

@Preview
@Composable
fun ScreenSignInPreview(){
    val navController = rememberNavController()
    SignInScreen(navController = navController)
}