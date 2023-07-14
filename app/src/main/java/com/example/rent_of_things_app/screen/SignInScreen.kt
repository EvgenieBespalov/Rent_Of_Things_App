package com.example.rent_of_things_app.screen.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.presentation.SignInScreenUiState
import com.example.rent_of_things_app.presentation.SignInScreenViewModel
import com.example.rent_of_things_app.screen.ScreenError
import com.example.rent_of_things_app.screen.ScreenLoadind
import com.example.rent_of_things_app.screen.navigation.Routes
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInScreen(
    viewModel: SignInScreenViewModel = koinViewModel(),
    navController: NavHostController
) {
    val state by viewModel.state.observeAsState(SignInScreenUiState.Initial)
//    when(state){
//        SignInScreenUiState.Initial    -> Unit
//        SignInScreenUiState.Loading    -> ScreenLoadind()
//        is SignInScreenUiState.Content -> Unit
//        is SignInScreenUiState.Error   -> ScreenError(errorText = (state as SignInScreenUiState.Error).message.orEmpty())
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 80.dp, top = 80.dp),
            text = "StudProkat",
            fontSize = 60.sp,
            color = Color.Black,
        )

        when(state){
            SignInScreenUiState.Initial    -> Unit
            SignInScreenUiState.Loading    -> ScreenLoadind()
            is SignInScreenUiState.Content -> {
                (state as SignInScreenUiState.Content).userData.id?.let {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 30.dp),
                        text = it,
                        fontSize = 25.sp,
                        color = greyText
                    )
                }
            }
            is SignInScreenUiState.Error   -> ScreenError(errorText = (state as SignInScreenUiState.Error).message.orEmpty())
        }

        Text(
            modifier = Modifier
                .padding(bottom = 30.dp),
            text = "Вход в профиль",
            fontSize = 25.sp,
            color = greyText
        )

        val maxSizeTextField = 30

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
                if (it.length <= maxSizeTextField) userEmailTextField = it

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
                viewModel.authorizationUser(
                    UserEntity(
                        id = null,
                        email = userEmailTextField,
                        name = null,
                        middleName = null,
                        surname = null,
                        password = userPasswordTextField,
                        registrationDate = null,
                        admin = false,
                        socialNetworks = null
                    )
                )
            },
            //enabled = userEmailCorrectTextField && userPasswordCorrectTextField,
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

        SignInScreenRow(navController = navController)
    }
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