package com.example.rent_of_things_app.data.repository

import com.example.rent_of_things_app.data.api.UserApi
import com.example.rent_of_things_app.data.converter.UserConverter
import com.example.rent_of_things_app.data.model.user.UserRegistrationAnswerModel
import com.example.rent_of_things_app.data.model.user.UserRegistrationRequestModel
import com.example.rent_of_things_app.domain.entity.UserEntity
import com.example.rent_of_things_app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userApi: UserApi,
    private val userConverter: UserConverter
): UserRepository {
    override suspend fun userRegistration(userRegistrationData: UserEntity): UserEntity =
        userConverter.convertUserRegistrationAnswerModelInUserEntity(userApi.userRegistration(userConverter.convertUserEntityInUserRegistrationRequestModel(userRegistrationData)))
}