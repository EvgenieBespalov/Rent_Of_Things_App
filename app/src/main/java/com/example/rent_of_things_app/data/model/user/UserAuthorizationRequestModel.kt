package com.example.rent_of_things_app.data.model.user

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserAuthorizationRequestModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
