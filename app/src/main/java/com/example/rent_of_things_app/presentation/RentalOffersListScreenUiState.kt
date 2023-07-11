package com.example.rent_of_things_app.presentation

sealed interface RentalOffersListScreenUiState{
    object Initial : RentalOffersListScreenUiState
    object Loading : RentalOffersListScreenUiState
    data class Content(val content: String) : RentalOffersListScreenUiState
    data class Error(val message: String?) : RentalOffersListScreenUiState
}