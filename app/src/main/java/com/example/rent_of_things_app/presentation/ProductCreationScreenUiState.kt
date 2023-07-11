package com.example.rent_of_things_app.presentation

sealed interface ProductCreationScreenUiState{
    object Initial : ProductCreationScreenUiState
    object Loading : ProductCreationScreenUiState
    data class Content(val content: String) : ProductCreationScreenUiState
    data class Error(val message: String?) : ProductCreationScreenUiState
}