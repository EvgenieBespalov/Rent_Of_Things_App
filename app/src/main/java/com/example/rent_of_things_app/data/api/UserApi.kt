package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.user.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @POST("/renting/users")
    suspend fun userRegistration(@Body userRegistrationRequestModel: UserRegistrationRequestModel): UserRegistrationAnswerModel

    @POST("/renting/login")
    suspend fun userAuthorization(@Body userAuthorizationRequestModel: UserAuthorizationRequestModel): UserAuthorizationAnswerModel

    @GET("/renting/users/{userId}")
    suspend fun getUserById(@Path("userId") userId: String): UserModel
}