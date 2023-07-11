package com.example.rent_of_things_app.presentation

sealed interface SignInScreenUiState{
    object Initial : SignInScreenUiState
    object Loading : SignInScreenUiState
    data class Content(val content: String) : SignInScreenUiState
    data class Error(val message: String?) : SignInScreenUiState
}