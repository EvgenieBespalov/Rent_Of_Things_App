package com.example.rent_of_things_app.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rent_of_things_app.screen.theme.*

@Composable
fun ScreenSignUp() {
    var textFieldEmail by remember { mutableStateOf("") }
    var textFieldPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(color = Color.White)
    ){
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
        ){}

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        clip = true
                        shape = RoundedCornerShape(15.dp)
                    }
                    .size(340.dp, 550.dp)
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
                        text = "Создание профиля",
                        fontSize = 25.sp,
                        color = greyText
                    )
                    //Возможно не сработает, так что пусть пока повисит в комментариях
                    OutlinedTextFieldSign(Icons.Outlined.AccountCircle, "Имя")
                    OutlinedTextFieldSign(Icons.Outlined.AccountCircle, "Фамилия")
                    OutlinedTextFieldSign(Icons.Outlined.Email, "Email")
                    OutlinedTextFieldSign(Icons.Outlined.Lock, "Пароль")
                    OutlinedTextFieldSign(Icons.Outlined.Lock, "Повторите пароль")

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
                            text = "Регистрация",
                            fontSize = fontTextFieldSignScreen
                        )
                    }
                }
            }

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
    }
}

@Preview
@Composable
fun ScreenSignUpPreview(){
    ScreenSignUp()
}