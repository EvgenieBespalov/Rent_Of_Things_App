package com.example.rent_of_things_app.data.repository

import android.content.SharedPreferences
import com.example.rent_of_things_app.data.api.UserApi
import com.example.rent_of_things_app.data.converter.UserConverter
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userConverter: UserConverter,
    private val sharedPreferences: SharedPreferences
): UserRepository {
    override suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity =
        userConverter.convertUserRegistrationAnswerModelInUserEntity(userApi.userRegistration(userConverter.convertUserEntityInUserRegistrationRequestModel(userRegistrationData)))

    override suspend fun userAuthorization(userEmailTextField: String, userPasswordTextField: String): UserEntity =
        userConverter.convertUserAuthorizationAnswerModelInUserEntity(userApi.userAuthorization(userConverter.convertUserDataInUserAuthorizationRequestModel(userEmailTextField, userPasswordTextField)))

    override suspend fun getUserById(userId: String): UserEntity =
        userConverter.converUserModelInUserEntity(userApi.getUserById(userId))

    override suspend fun saveUserIdInApp(user: UserEntity) {
        sharedPreferences.edit().apply(){
            putString("USER_ID", user.id)
        }
    }

    override suspend fun getUserIdFromApp(): String? = sharedPreferences.getString("USER_ID", "4d561e90-16eb-4040-bbc2-573054dfcb2a")

    override suspend fun deleteUserFromApp(user: UserEntity) {
        sharedPreferences.edit().clear().apply()
    }
}