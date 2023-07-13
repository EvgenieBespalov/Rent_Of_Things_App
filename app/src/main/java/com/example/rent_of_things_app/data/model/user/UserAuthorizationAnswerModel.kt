package com.example.rent_of_things_app.data.model.user

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserAuthorizationAnswerModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("registration_date")
    val registrationDate: Date,
    @SerializedName("permission_level")
    val permissionLevel: String
)
