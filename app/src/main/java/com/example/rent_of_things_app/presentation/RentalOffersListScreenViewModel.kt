package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.domain.usecase.GetProductByUserIDUseCase
import com.example.rent_of_things_app.domain.usecase.LoadRentalOffersListUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class RentalOffersListScreenViewModel(
    private val loadRentalOffersListUseCase: LoadRentalOffersListUseCase,
    private val getProductByUserIDUseCase: GetProductByUserIDUseCase
): ViewModel(){
    private val _state: MutableLiveData<RentalOffersListScreenUiState> = MutableLiveData(RentalOffersListScreenUiState.Initial)
    val state: LiveData<RentalOffersListScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = RentalOffersListScreenUiState.Initial
        }
    }

    fun getRentalOffersList(){
        viewModelScope.launch {
            _state.value = RentalOffersListScreenUiState.Loading

            try {
                val userId = loadRentalOffersListUseCase()
                val product = userId?.let { getProductByUserIDUseCase(it) }
                _state.value = RentalOffersListScreenUiState.Content(userId, product)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                val userId = loadRentalOffersListUseCase()
                _state.value = RentalOffersListScreenUiState.Content(userId, null)
                //_state.value = RentalOffersListScreenUiState.Error(ex.message)
            }

        }
    }
}