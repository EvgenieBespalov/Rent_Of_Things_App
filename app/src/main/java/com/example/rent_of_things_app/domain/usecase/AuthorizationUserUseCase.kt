package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class AuthorizationUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userAuthorizationData: UserEntity): UserEntity?  {
        var userData = repository.userAuthorization(userAuthorizationData)

        repository.saveUserIdInApp(userData)

        return repository.getUserIdFromApp()?.let { repository.getUserById(it) }
    }
}