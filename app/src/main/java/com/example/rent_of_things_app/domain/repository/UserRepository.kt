package com.example.rent_of_things_app.domain.repository

import com.example.rent_of_things_app.domain.entity.UserEntity

interface UserRepository {
    suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity
    suspend fun userAuthorization(userAuthorizationData: UserEntity): UserEntity
}