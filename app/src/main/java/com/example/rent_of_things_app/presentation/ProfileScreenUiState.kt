package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.UserEntity

sealed interface ProfileScreenUiState{
    object Initial : ProfileScreenUiState
    object Loading : ProfileScreenUiState
    data class Content(val userData: UserEntity?) : ProfileScreenUiState
    data class Error(val message: String?) : ProfileScreenUiState
}