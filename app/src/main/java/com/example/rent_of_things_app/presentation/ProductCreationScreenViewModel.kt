package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductCreationScreenViewModel(): ViewModel() {
    private val _state: MutableLiveData<ProductCreationScreenUiState> =
        MutableLiveData(ProductCreationScreenUiState.Initial)
    val state: LiveData<ProductCreationScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductCreationScreenUiState.Initial
        }
    }

    fun getProductInfo() {
        viewModelScope.launch {
            _state.value = ProductCreationScreenUiState.Loading

            try {
                _state.value = ProductCreationScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductCreationScreenUiState.Error(ex.message)
            }

        }
    }
}