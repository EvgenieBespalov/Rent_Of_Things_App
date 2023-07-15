package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.ProductEntity

sealed interface ProductCreationScreenUiState{
    object Initial : ProductCreationScreenUiState
    object Loading : ProductCreationScreenUiState
    data class Content(val productData: ProductEntity) : ProductCreationScreenUiState
    data class Error(val message: String?) : ProductCreationScreenUiState
}