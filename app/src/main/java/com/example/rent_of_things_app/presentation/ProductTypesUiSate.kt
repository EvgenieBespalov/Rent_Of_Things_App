package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.ProductTypeEntity

sealed interface ProductTypesUiSate{
    object Initial : ProductTypesUiSate
    object Loading : ProductTypesUiSate
    data class Content(val productType: ProductTypeEntity) : ProductTypesUiSate
    data class Error(val message: String?) : ProductTypesUiSate
}