package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.UserEntity

sealed interface SignUpScreenUiState{
    object Initial : SignUpScreenUiState
    object Loading : SignUpScreenUiState
    data class Content(val userData: UserEntity) : SignUpScreenUiState
    data class Error(val message: String?) : SignUpScreenUiState
}