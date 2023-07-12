package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.domain.usecase.GetIdProductUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductCardScreenViewModel(
    private val getIdProductUseCase: GetIdProductUseCase
): ViewModel() {
    private val _state: MutableLiveData<ProductCardScreenUiState> =
        MutableLiveData(ProductCardScreenUiState.Initial)
    val state: LiveData<ProductCardScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductCardScreenUiState.Initial
        }
    }

    fun getProduct(idPoduct: String) {
        viewModelScope.launch {
            _state.value = ProductCardScreenUiState.Loading

            try {
                val idPoduct = getIdProductUseCase(idPoduct)
                _state.value = ProductCardScreenUiState.Content(idPoduct)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductCardScreenUiState.Error(ex.message)
            }

        }
    }
}