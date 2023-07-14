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
import androidx.navigation.NavHostController
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.presentation.ProductCardScreenUiState
import com.example.rent_of_things_app.presentation.ProductCardScreenViewModel
import com.example.rent_of_things_app.presentation.ProfileScreenUiState
import com.example.rent_of_things_app.presentation.ProfileScreenViewModel
import com.example.rent_of_things_app.screen.navigation.Routes
import com.example.rent_of_things_app.screen.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileScreenViewModel = koinViewModel(),
    navController: NavHostController
){
    val state by viewModel.state.observeAsState(ProfileScreenUiState.Initial)

    when(state){
        ProfileScreenUiState.Initial    -> viewModel.getProfileInfo()
        ProfileScreenUiState.Loading    -> ScreenLoadind()
        is ProfileScreenUiState.Content -> when((state as ProfileScreenUiState.Content).userData){
            null -> ProfileScreenRegistrationButton(navController = navController)
            else -> (state as ProfileScreenUiState.Content).userData?.let { ProfileScreenMain(it) }
        }
        is ProfileScreenUiState.Error   -> ScreenError(errorText = (state as ProfileScreenUiState.Error).message.orEmpty())
    }
}

@Composable
fun ProfileScreenMain(userData: UserEntity){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundGray)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ProfileScreenMainInfo(userData = userData)
        ProfileScreenEditButton()
        ProfileScreenExitButton()
    }
}

@Composable
fun ProfileScreenMainInfo(userData: UserEntity){
    Column(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 5.dp)
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(5.dp, 5.dp, 0.dp, 0.dp),
            fontSize = 20.sp,
            color = greyText,
            text = "ФИО"
        )
        userData.name?.let {
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                fontSize = 25.sp,
                text = it
            )
        }
        userData.middleName?.let {
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                fontSize = 25.sp,
                text = it
            )
        }
        userData.surname?.let {
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 25.sp,
                text = it
            )
        }
        Text(
            modifier = Modifier
                .padding(5.dp, 0.dp, 0.dp, 0.dp),
            fontSize = 20.sp,
            color = greyText,
            text = "Дата регистрации"
        )
        Text(
            modifier = Modifier
                .padding(5.dp, 0.dp, 5.dp, 5.dp),
            fontSize = 25.sp,
            text = userData.registrationDate.toString()
        )
        Text(
            modifier = Modifier
                .padding(5.dp, 0.dp, 0.dp, 0.dp),
            fontSize = 20.sp,
            color = greyText,
            text = "Email"
        )
        userData.email?.let {
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 25.sp,
                text = it
            )
        }
        Text(
            modifier = Modifier
                .padding(5.dp, 0.dp, 5.dp, 0.dp),
            fontSize = 20.sp,
            color = greyText,
            text = "Социальные сети"
        )
        userData.socialNetworks?.let {
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 25.sp,
                text = it.joinToString(separator = ", ")
            )
        }
    }
}

@Composable
fun ProfileScreenEditButton(){
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
                text = "Редактировать профиль",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ProfileScreenExitButton(
    viewModel: ProfileScreenViewModel = koinViewModel()
){
    Box(
        modifier = Modifier
            .background(color = Color.Transparent)
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { viewModel.exitFromProfile() },
            colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive),
            shape = RoundedCornerShape(shape10)
        ) {
            Text(
                text = "Выйти из профиля",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ProfileScreenRegistrationButton(navController: NavHostController){
    Box(
        modifier = Modifier
            .background(color = Color.Transparent)
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
    ){
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                navController.navigate(Routes.SignUpScreenRoute.route)
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = yellowActive),
            shape = RoundedCornerShape(shape10)
        ) {
            Text(
                text = "Зарегистрироваться",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}