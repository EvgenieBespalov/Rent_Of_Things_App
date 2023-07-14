package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("/renting/products")
    suspend fun getAllProduct(): List<ProductModel>

    @GET("/renting/products/{productId}")
    suspend fun getIdProduct(@Path("productId") productId: String): ProductModel

    @GET("/renting/products/product_types/{productType}")
    suspend fun getProductsByType(@Path("productType") productType: String): List<ProductModel>
}