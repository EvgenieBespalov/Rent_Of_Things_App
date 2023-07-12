package com.example.rent_of_things_app.data.repository

import com.example.rent_of_things_app.data.api.ProductApi
import com.example.rent_of_things_app.data.converter.ProductConverter
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productApi: ProductApi,
    private val productConverter: ProductConverter
): ProductRepository {
    override suspend fun getAllProduct(): List<ProductEntity> =
        productApi.getAllProduct().map { productConverter.convertProductModelInEntity(it) }
}