package com.example.rent_of_things_app.domain.repository

import com.example.rent_of_things_app.domain.entity.UserEntity

interface UserRepository {
    suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity
    suspend fun userAuthorization(userEmailTextField: String, userPasswordTextField: String): UserEntity
    suspend fun getUserById(userId: String): UserEntity
    suspend fun saveUserIdInApp(user: UserEntity)
    suspend fun getUserIdFromApp(): String?
    suspend fun deleteUserFromApp()
}