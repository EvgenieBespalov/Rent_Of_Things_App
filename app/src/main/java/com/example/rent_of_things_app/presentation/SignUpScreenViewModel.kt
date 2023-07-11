package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class SignUpScreenViewModel(): ViewModel() {
    private val _state: MutableLiveData<SignUpScreenUiState> =
        MutableLiveData(SignUpScreenUiState.Initial)
    val state: LiveData<SignUpScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = SignUpScreenUiState.Initial
        }
    }

    fun getRentalOffersList() {
        viewModelScope.launch {
            _state.value = SignUpScreenUiState.Loading

            try {
                _state.value = SignUpScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = SignUpScreenUiState.Error(ex.message)
            }

        }
    }
}