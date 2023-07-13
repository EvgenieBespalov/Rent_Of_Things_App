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
    val state by viewModel.state.observeAsState(ProfileScreenUiState.Content("ii"))

    when(state){
        ProfileScreenUiState.Initial    -> viewModel.getProfileInfo()
        ProfileScreenUiState.Loading    -> ScreenLoadind()
        is ProfileScreenUiState.Content -> ProfileScreenMain(navController = navController)
        is ProfileScreenUiState.Error   -> ScreenError(errorText = (state as ProfileScreenUiState.Error).message.orEmpty())
    }

}

@Composable
fun ProfileScreenMain(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.BottomCenter,
    ){
        ProfileScreenMainInfo()
        ProfileScreenEditButton()
        ProfileScreenRegistrationButton(navController = navController)
    }
}

@Composable
fun ProfileScreenMainInfo(){
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
            Text(
                modifier = Modifier
                    .padding(5.dp, 5.dp, 0.dp, 0.dp),
                fontSize = 15.sp,
                color = greyText,
                text = "ФИО"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                fontSize = 20.sp,
                text = "Name"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                fontSize = 20.sp,
                text = "MiddleName"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = "Surname"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp),
                fontSize = 15.sp,
                color = greyText,
                text = "Дата регистрации"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = "date reg"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp),
                fontSize = 15.sp,
                color = greyText,
                text = "Email"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = "email@email.ru"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 0.dp),
                fontSize = 15.sp,
                color = greyText,
                text = "Социальные сети"
            )
            Text(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 5.dp, 5.dp),
                fontSize = 20.sp,
                text = "vk.ru"
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

@Preview
@Composable
fun ProfileScreenPreview(){
    //ProfileScreen()
}