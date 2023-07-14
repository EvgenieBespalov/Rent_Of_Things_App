package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.domain.usecase.LoadUserProfileUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ProfileScreenViewModel(
    private val loadUserProfileUseCase: LoadUserProfileUseCase
): ViewModel(){
    private val _state: MutableLiveData<ProfileScreenUiState> = MutableLiveData(ProfileScreenUiState.Initial)
    val state: LiveData<ProfileScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = ProfileScreenUiState.Initial
        }
    }

    fun getProfileInfo(){
        viewModelScope.launch {
            _state.value = ProfileScreenUiState.Loading

            try {
                val userData = loadUserProfileUseCase()
                _state.value = ProfileScreenUiState.Content(userData)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = ProfileScreenUiState.Error(ex.message)
            }

        }
    }
}