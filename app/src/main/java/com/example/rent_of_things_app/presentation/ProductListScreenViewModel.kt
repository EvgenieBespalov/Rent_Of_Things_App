package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.data.model.ProductTypeModel
import com.example.rent_of_things_app.domain.entity.ProductTypeEntity
import com.example.rent_of_things_app.domain.usecase.GetAllProductUseCase
import com.example.rent_of_things_app.domain.usecase.GetProductTypeUseCase
import com.example.rent_of_things_app.domain.usecase.GetProductsByTypeUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProductListScreenViewModel(
    private val getAllProductUseCase: GetAllProductUseCase,
    private val getProductTypeUseCase: GetProductTypeUseCase,
    private val getProductsByTypeUseCase: GetProductsByTypeUseCase
): ViewModel(){
    private val _state: MutableLiveData<ProductListScreenUiState> = MutableLiveData(ProductListScreenUiState.Initial)
    val state: LiveData<ProductListScreenUiState> = _state

    private val _stateProductType: MutableLiveData<ProductTypesUiSate> = MutableLiveData(ProductTypesUiSate.Initial)
    val stateProductType: LiveData<ProductTypesUiSate> = _stateProductType

    fun initial() {
        viewModelScope.launch {
            _state.value = ProductListScreenUiState.Initial
        }
    }

    fun getAllProductType(){
        viewModelScope.launch {
            _stateProductType.value = ProductTypesUiSate.Loading

            try {
                val allTypeProduct = getProductTypeUseCase()
                _stateProductType.value = ProductTypesUiSate.Content(allTypeProduct)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _stateProductType.value = ProductTypesUiSate.Error(ex.message)
            }
        }
    }

    fun getAllProduct(){
        viewModelScope.launch {
            _state.value = ProductListScreenUiState.Loading

            try {
                val allProduct = getAllProductUseCase()
                _state.value = ProductListScreenUiState.Content(allProduct)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductListScreenUiState.Error(ex.message)
            }
        }
    }

    fun getProductsByType(productType: String){
        viewModelScope.launch {
            _state.value = ProductListScreenUiState.Loading

            try {
                val productByType = getProductsByTypeUseCase(productType)
                _state.value = ProductListScreenUiState.Content(productByType)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProductListScreenUiState.Error(ex.message)
            }

        }
    }
}