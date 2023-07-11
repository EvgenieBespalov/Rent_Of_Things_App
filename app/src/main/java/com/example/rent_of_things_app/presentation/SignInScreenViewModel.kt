package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class SignInScreenViewModel(): ViewModel() {
    private val _state: MutableLiveData<SignInScreenUiState> =
        MutableLiveData(SignInScreenUiState.Initial)
    val state: LiveData<SignInScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = SignInScreenUiState.Initial
        }
    }

    fun getRentalOffersList() {
        viewModelScope.launch {
            _state.value = SignInScreenUiState.Loading

            try {
                _state.value = SignInScreenUiState.Content("it")
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = SignInScreenUiState.Error(ex.message)
            }

        }
    }
}