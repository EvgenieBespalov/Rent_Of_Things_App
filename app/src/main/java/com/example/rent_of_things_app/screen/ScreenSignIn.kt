package com.example.rent_of_things_app.screen.theme

import android.annotation.SuppressLint
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenSignIn() {
    var textFieldEmail by remember { mutableStateOf("") }
    var textFieldPassword by remember { mutableStateOf("") }

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
                    /*OutlinedTextField(
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
                    )*/
                    //Возможно не сработает, так что пусть пока повисит в комментариях
                    OutlinedTextFieldSign(Icons.Outlined.Email, "Email")
                    OutlinedTextFieldSign(Icons.Outlined.Lock, "Пароль")

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
                    modifier = Modifier.clickable( onClick = {  }),
                    color = yellowActive
                )
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
            .padding(bottom = 20.dp)
            .size(300.dp, 55.dp),
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

@Preview
@Composable
fun ScreenSignInPreview(){
    ScreenSignIn()
}