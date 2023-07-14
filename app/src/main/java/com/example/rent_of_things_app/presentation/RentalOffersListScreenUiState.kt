package com.example.rent_of_things_app.presentation

import com.example.rent_of_things_app.domain.entity.ProductEntity

sealed interface RentalOffersListScreenUiState{
    object Initial : RentalOffersListScreenUiState
    object Loading : RentalOffersListScreenUiState
    data class Content(val userId: String?, val listRentalOffers: List<ProductEntity>?) : RentalOffersListScreenUiState
    data class Error(val message: String?) : RentalOffersListScreenUiState
}