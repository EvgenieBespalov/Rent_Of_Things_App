package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.user.UserRegistrationAnswerModel
import com.example.rent_of_things_app.data.model.user.UserRegistrationRequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/renting/users")
    suspend fun userRegistration(@Body userRegistrationRequestModel: UserRegistrationRequestModel): UserRegistrationAnswerModel
}