package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductCardScreenViewModel(): ViewModel() {
    private val _state: MutableLiveData<ProductCardScreenUiState> =
        MutableLiveData(ProductCardScreenUiState.Initial)
    val state: LiveData<ProductCardScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductCardScreenUiState.Initial
        }
    }

    fun getProductInfo() {
        viewModelScope.launch {
            _state.value = ProductCardScreenUiState.Loading

            try {
                _state.value = ProductCardScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductCardScreenUiState.Error(ex.message)
            }

        }
    }
}