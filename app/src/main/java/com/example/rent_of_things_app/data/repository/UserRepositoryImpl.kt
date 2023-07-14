package com.example.rent_of_things_app.data.repository

import com.example.rent_of_things_app.data.api.UserApi
import com.example.rent_of_things_app.data.converter.UserConverter
import com.example.rent_of_things_app.di.SharedPreferencesManager
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userConverter: UserConverter,
    private val sharedPreferences: SharedPreferencesManager
): UserRepository {
    override suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity =
        userConverter.convertUserRegistrationAnswerModelInUserEntity(userApi.userRegistration(userConverter.convertUserEntityInUserRegistrationRequestModel(userRegistrationData)))

    override suspend fun userAuthorization(userEmailTextField: String, userPasswordTextField: String): UserEntity =
        userConverter.convertUserAuthorizationAnswerModelInUserEntity(userApi.userAuthorization(userConverter.convertUserDataInUserAuthorizationRequestModel(userEmailTextField, userPasswordTextField)))

    override suspend fun getUserById(userId: String): UserEntity =
        userConverter.converUserModelInUserEntity(userApi.getUserById(userId))

    override suspend fun saveUserIdInApp(user: UserEntity) {
        user.id?.let { sharedPreferences.saveUserId(it) }
    }

    override suspend fun getUserIdFromApp(): String? =
        sharedPreferences.userId

    override suspend fun deleteUserFromApp(user: UserEntity) {
        sharedPreferences.clearUserId()
    }
}