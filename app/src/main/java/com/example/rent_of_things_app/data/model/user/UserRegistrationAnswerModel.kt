package com.example.rent_of_things_app.data.model.user

import com.google.gson.annotations.SerializedName
import java.util.Date

data class UserRegistrationAnswerModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("social_networks")
    val socialNetworks: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("middle_name")
    val middleName: String,
    @SerializedName("registration_date")
    val registrationDate: Date
)