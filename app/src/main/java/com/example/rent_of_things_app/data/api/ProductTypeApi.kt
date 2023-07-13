package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.ProductTypeModel
import retrofit2.http.GET

interface ProductTypeApi {
    @GET("/renting/products/product_types")
    suspend fun getAllProductType(): ProductTypeModel
}