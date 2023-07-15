package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.domain.usecase.CreateProductUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductCreationScreenViewModel(
    private val createProductUseCase: CreateProductUseCase
): ViewModel() {
    private val _state: MutableLiveData<ProductCreationScreenUiState> =
        MutableLiveData(ProductCreationScreenUiState.Initial)
    val state: LiveData<ProductCreationScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductCreationScreenUiState.Initial
        }
    }

    fun createProduct(productData: ProductEntity) {
        viewModelScope.launch {
            _state.value = ProductCreationScreenUiState.Loading

            try {
                val product = createProductUseCase(productData)
                _state.value = ProductCreationScreenUiState.Content(product)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductCreationScreenUiState.Error(ex.message)
            }

        }
    }
}