package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class RentalOffersListScreenViewModel(): ViewModel(){
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
                _state.value = RentalOffersListScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = RentalOffersListScreenUiState.Error(ex.message)
            }

        }
    }
}