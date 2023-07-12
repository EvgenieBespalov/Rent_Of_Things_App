package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.ProductModel
import retrofit2.http.GET

interface ProductApi {
    @GET("/renting/products")
    suspend fun getAllProduct(): List<ProductModel>
}