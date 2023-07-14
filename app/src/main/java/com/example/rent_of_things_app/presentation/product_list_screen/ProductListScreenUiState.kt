package com.example.rent_of_things_app.presentation.product_list_screen

import com.example.rent_of_things_app.domain.entity.ProductEntity

sealed interface ProductListScreenUiState{
    object Initial : ProductListScreenUiState
    object Loading : ProductListScreenUiState
    data class Content(val productList: List<ProductEntity>) : ProductListScreenUiState
    data class Error(val message: String?) : ProductListScreenUiState
}