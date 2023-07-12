package com.example.rent_of_things_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.rent_of_things_app.screen.BottomMenuScreen
import com.example.rent_of_things_app.screen.BottomNavigationBar
import com.example.rent_of_things_app.screen.NavHostContainer
import com.example.rent_of_things_app.screen.ProductListScreen
import com.example.rent_of_things_app.screen.offer_list_screens.RentalOffersListScreen
import com.example.rent_of_things_app.screen.theme.Rent_Of_Things_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Rent_Of_Things_AppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomMenuScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Rent_Of_Things_AppTheme {
        Greeting("Android")
    }
}