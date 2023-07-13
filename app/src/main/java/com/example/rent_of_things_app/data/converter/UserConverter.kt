package com.example.rent_of_things_app.data.converter

import com.example.rent_of_things_app.data.model.user.*
import com.example.rent_of_things_app.domain.entity.UserEntity

class UserConverter {
    fun convertUserEntityInUserRegistrationRequestModel(from: UserEntity): UserRegistrationRequestModel =
        UserRegistrationRequestModel(
            email = when(from.email){
                null -> ""
                else -> from.email
                                    },
            socialNetworks = from.socialNetworks,
            name = when(from.name){
                null -> ""
                else -> from.name
                                  },
            middleName = from.middleName,
            surname = when(from.surname){
                null -> ""
                else -> from.surname
                                        },
            password = when(from.password){
                null -> "123"
                else -> from.password
            }
        )

    fun converUserModelInUserEntity(from: UserModel): UserEntity =
        UserEntity(
            id = from.id,
            email = from.email,
            socialNetworks = from.socialNetworks,
            name = from.name,
            surname = from.surname,
            middleName = from.middleName,
            registrationDate = from.registrationDate,
            password = null,
            admin = false
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

    fun convertUserAuthorizationAnswerModelInUserEntity(from: UserAuthorizationAnswerModel): UserEntity =
        UserEntity(
            id = from.id,
            email = null,
            socialNetworks = null,
            name = null,
            middleName = null,
            surname = null,
            registrationDate = from.registrationDate,
            password = null,
            admin = when(from.permissionLevel){
                "user" -> false
                else -> true
            }
        )

    fun convertUserEntityInUserAuthorizationRequestModel(from: UserEntity): UserAuthorizationRequestModel =
        UserAuthorizationRequestModel(
            email = when(from.email){
                null -> ""
                else -> from.email
            },
            password = when(from.password){
                null -> ""
                else -> from.password
            }
        )
}