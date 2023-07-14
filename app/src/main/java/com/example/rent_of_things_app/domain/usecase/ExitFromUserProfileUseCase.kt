package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.repository.UserRepository

class ExitFromUserProfileUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke() {
        repository.deleteUserFromApp()
    }
}