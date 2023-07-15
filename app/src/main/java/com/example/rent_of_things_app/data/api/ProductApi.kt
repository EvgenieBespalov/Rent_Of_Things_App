package com.example.rent_of_things_app.data.api

import com.example.rent_of_things_app.data.model.product.ProductAnswerModel
import com.example.rent_of_things_app.data.model.product.ProductModel
import com.example.rent_of_things_app.data.model.product.ProductRequestModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApi {
    @GET("/renting/products")
    suspend fun getAllProduct(): List<ProductModel>

    @GET("/renting/products/{productId}")
    suspend fun getIdProduct(@Path("productId") productId: String): ProductModel

    @GET("/renting/products/product_types/{productType}")
    suspend fun getProductsByType(@Path("productType") productType: String): List<ProductModel>

    @GET("/renting/products/{userId}/all")
    suspend fun getProductByUserId(@Path("userId") userId: String): List<ProductModel>

    @POST("/renting/products")
    suspend fun createProduct(@Body productRequestModel: ProductRequestModel): ProductAnswerModel
}