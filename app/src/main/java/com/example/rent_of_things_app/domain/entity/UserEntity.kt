package com.example.rent_of_things_app.domain.entity

import java.util.Date

data class UserEntity(
    val id: String?,
    val email: String,
    val socialNetworks: List<String>,
    val name: String,
    val surname: String,
    val middleName: String,
    val registrationDate: Date?,
    val password: String?,
    val admin: Boolean
)