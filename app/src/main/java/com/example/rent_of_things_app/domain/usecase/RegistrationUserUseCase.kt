package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class RegistrationUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userRegistrationData: UserEntity): UserEntity = repository.userRegistration(userRegistrationData)
}