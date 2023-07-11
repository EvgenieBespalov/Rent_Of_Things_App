package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductListScreenViewModel(): ViewModel(){
    private val _state: MutableLiveData<ProductListScreenUiState> = MutableLiveData(ProductListScreenUiState.Initial)
    val state: LiveData<ProductListScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductListScreenUiState.Initial
        }
    }

    fun getProductList(){
        viewModelScope.launch {
            _state.value = ProductListScreenUiState.Loading

            try {
                _state.value = ProductListScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductListScreenUiState.Error(ex.message)
            }

        }
    }
}