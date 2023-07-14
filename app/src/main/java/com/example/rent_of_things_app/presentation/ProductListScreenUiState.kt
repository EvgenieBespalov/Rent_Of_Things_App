package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.domain.entity.ProductTypeEntity

sealed interface ProductListScreenUiState{
    object Initial : ProductListScreenUiState
    object Loading : ProductListScreenUiState
    data class Content(val productList: List<ProductEntity>, val productType: ProductTypeEntity) : ProductListScreenUiState
    data class Error(val message: String?) : ProductListScreenUiState
}