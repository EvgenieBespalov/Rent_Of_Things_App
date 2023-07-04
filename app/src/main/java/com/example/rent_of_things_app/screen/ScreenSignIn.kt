package com.example.rent_of_things_app.screen.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ScreenSignIn() {
    var textFieldEmail by remember { mutableStateOf("Email") }
    var textFieldPassword by remember { mutableStateOf("Пароль") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier.
            size(300.dp, 250.dp).
            background(Color.White)
        ){
            Column(){
                Text(
                    text = "Вход в профиль",
                    fontSize=25.sp,
                    color = Color.Black
                )
                TextField(
                    value = textFieldEmail,
                    onValueChange = { textFieldEmail = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        //backgroundColor = colorAccent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = MaterialTheme.shapes.small.copy(
                        topEnd = CornerSize(15.dp),
                        topStart = CornerSize(15.dp),
                        bottomEnd = CornerSize(15.dp),
                        bottomStart = CornerSize(15.dp)
                    ),
                    textStyle = TextStyle(fontSize = 25.sp),
                )
                TextField(
                    value = textFieldPassword,
                    onValueChange = { textFieldPassword = it },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.White,
                        //backgroundColor = colorAccent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = MaterialTheme.shapes.small.copy(
                        topEnd = CornerSize(15.dp),
                        topStart = CornerSize(15.dp),
                        bottomEnd = CornerSize(15.dp),
                        bottomStart = CornerSize(15.dp)
                    ),
                    textStyle = TextStyle(fontSize = 25.sp),
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
                    shape = MaterialTheme.shapes.small.copy(
                        topEnd = CornerSize(15.dp),
                        topStart = CornerSize(15.dp),
                        bottomEnd = CornerSize(15.dp),
                        bottomStart = CornerSize(15.dp)
                    ),
                ){
                    Text(
                        text = "Вход",
                        fontSize = 25.sp
                    )
                }
            }
        }

        Row(){
            Text(
                text = "Нет аккаунта?",
                fontSize = 20.sp
            )
            Text("Зарегистрируйтесь",
                fontSize = 20.sp,
                modifier = Modifier.clickable( onClick = {  })
            )
        }
    }
}

@Preview
@Composable
fun ScreenSignInPreview(){
    ScreenSignIn()
}