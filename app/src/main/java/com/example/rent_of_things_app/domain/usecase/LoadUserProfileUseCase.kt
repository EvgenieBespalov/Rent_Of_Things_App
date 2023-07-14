package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class LoadUserProfileUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(): UserEntity? {
        return repository.getUserIdFromApp()?.let { repository.getUserById(it) }
    }
}