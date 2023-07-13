package com.example.rent_of_things_app.screen.navigation

sealed class Routes(val route: String) {
    object ProfileScreenRoute : Routes("Profile")
    object ProductListScreenRoute : Routes("ProductList")
    object RentalOffersListScreenRoute : Routes("RentalOffersList")
    object ProductCardScreenRoute : Routes("ProductCard")
    object ProductCreationScreenRoute : Routes("ProductCreation")
    object SignUpScreenRoute : Routes("SignUp")
}