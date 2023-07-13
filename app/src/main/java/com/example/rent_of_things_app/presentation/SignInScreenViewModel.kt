package com.example.rent_of_things_app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.usecase.AuthorizationUserUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class SignInScreenViewModel(
    private val authorizationUserUseCase: AuthorizationUserUseCase
): ViewModel() {
    private val _state: MutableLiveData<SignInScreenUiState> =
        MutableLiveData(SignInScreenUiState.Initial)
    val state: LiveData<SignInScreenUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = SignInScreenUiState.Initial
        }
    }

    fun authorizationUser(authorizationUserData: UserEntity) {
        viewModelScope.launch {
            _state.value = SignInScreenUiState.Loading

            try {
                val userData = authorizationUserUseCase(authorizationUserData)
                _state.value = SignInScreenUiState.Content(userData)
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = SignInScreenUiState.Error(ex.message)
            }

        }
    }
}