package com.example.rent_of_things_app.presentation

sealed interface ProfileScreenUiState{
    object Initial : ProfileScreenUiState
    object Loading : ProfileScreenUiState
    data class Content(val content: String) : ProfileScreenUiState
    data class Error(val message: String?) : ProfileScreenUiState
}