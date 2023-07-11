package com.example.rent_of_things_app.presentation

sealed interface ProductCardScreenUiState{
    object Initial : ProductCardScreenUiState
    object Loading : ProductCardScreenUiState
    data class Content(val content: String) : ProductCardScreenUiState
    data class Error(val message: String?) : ProductCardScreenUiState
}