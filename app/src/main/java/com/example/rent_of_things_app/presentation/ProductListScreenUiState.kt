package com.example.rent_of_things_app.presentation

sealed interface ProductListScreenUiState{
    object Initial : ProductListScreenUiState
    object Loading : ProductListScreenUiState
    data class Content(val content: String) : ProductListScreenUiState
    data class Error(val message: String?) : ProductListScreenUiState
}