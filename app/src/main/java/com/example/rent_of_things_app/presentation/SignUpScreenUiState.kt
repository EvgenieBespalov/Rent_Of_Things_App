package com.example.rent_of_things_app.presentation

sealed interface SignUpScreenUiState{
    object Initial : SignUpScreenUiState
    object Loading : SignUpScreenUiState
    data class Content(val content: String) : SignUpScreenUiState
    data class Error(val message: String?) : SignUpScreenUiState
}