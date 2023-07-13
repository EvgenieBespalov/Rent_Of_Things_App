package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.UserEntity

sealed interface SignInScreenUiState{
    object Initial : SignInScreenUiState
    object Loading : SignInScreenUiState
    data class Content(val userData: UserEntity) : SignInScreenUiState
    data class Error(val message: String?) : SignInScreenUiState
}