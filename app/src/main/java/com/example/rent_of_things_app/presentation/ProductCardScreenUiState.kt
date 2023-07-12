package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.ProductEntity

sealed interface ProductCardScreenUiState{
    object Initial : ProductCardScreenUiState
    object Loading : ProductCardScreenUiState
    data class Content(val product: ProductEntity) : ProductCardScreenUiState
    data class Error(val message: String?) : ProductCardScreenUiState
}