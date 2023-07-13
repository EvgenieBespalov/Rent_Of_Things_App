package com.example.rent_of_things_app.data.repository

import android.content.SharedPreferences
import com.example.rent_of_things_app.data.api.UserApi
import com.example.rent_of_things_app.data.converter.UserConverter
import com.example.rent_of_things_app.data.model.user.UserRegistrationAnswerModel
import com.example.rent_of_things_app.data.model.user.UserRegistrationRequestModel
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userConverter: UserConverter,
    private val sharedPreferences: SharedPreferences
): UserRepository {
    override suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity =
        userConverter.convertUserRegistrationAnswerModelInUserEntity(userApi.userRegistration(userConverter.convertUserEntityInUserRegistrationRequestModel(userRegistrationData)))

    override suspend fun userAuthorization(userAuthorizationData: UserEntity): UserEntity =
        userConverter.convertUserAuthorizationAnswerModelInUserEntity(userApi.userAuthorization(userConverter.convertUserEntityInUserAuthorizationRequestModel(userAuthorizationData)))

    override suspend fun saveUserIdInApp(user: UserEntity) {
        sharedPreferences.edit().apply(){
            putString("USER_ID", user.id)
        }
    }

    override suspend fun getUserIdFromApp(): String? = sharedPreferences.getString("USER_ID", null)

    override suspend fun deleteUserFromApp(user: UserEntity) {
        sharedPreferences.edit().clear().apply()
    }
}