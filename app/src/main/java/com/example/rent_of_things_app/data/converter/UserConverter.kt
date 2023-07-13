package com.example.rent_of_things_app.data.converter

import com.example.rent_of_things_app.data.model.user.UserRegistrationAnswerModel
import com.example.rent_of_things_app.data.model.user.UserRegistrationRequestModel
import com.example.rent_of_things_app.domain.entity.UserEntity

class UserConverter {
    fun convertUserEntityInUserRegistrationRequestModel(from: UserEntity): UserRegistrationRequestModel =
        UserRegistrationRequestModel(
            email = from.email,
            socialNetworks = from.socialNetworks,
            name = from.name,
            middleName = from.middleName,
            surname = from.surname,
            password = when(from.password){
                null -> "123"
                else -> from.password
            }
        )

    fun convertUserRegistrationAnswerModelInUserEntity(from: UserRegistrationAnswerModel): UserEntity =
        UserEntity(
            id = from.id,
            email = from.email,
            socialNetworks = from.socialNetworks,
            name = from.name,
            middleName = from.middleName,
            surname = from.surname,
            registrationDate = from.registrationDate,
            password = null,
            admin = false
        )
}