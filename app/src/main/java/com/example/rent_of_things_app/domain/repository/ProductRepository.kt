package com.example.rent_of_things_app.domain.repository

import com.example.rent_of_things_app.domain.entity.ProductEntity

interface ProductRepository {
    suspend fun getAllProduct(): List<ProductEntity>

    suspend fun getIdProduct(productId: String): ProductEntity

    suspend fun getProductsByType(productType: String): List<ProductEntity>

    suspend fun getProductByUserId(userId: String): List<ProductEntity>

    suspend fun createProduct(productData: ProductEntity): ProductEntity
}