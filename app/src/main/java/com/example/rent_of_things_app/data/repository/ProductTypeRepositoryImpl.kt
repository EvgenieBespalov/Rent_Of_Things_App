package com.example.rent_of_things_app.data.repository

import com.example.rent_of_things_app.data.api.ProductTypeApi
import com.example.rent_of_things_app.data.converter.ProductTypeConverter
import com.example.rent_of_things_app.domain.entity.ProductTypeEntity
import com.example.rent_of_things_app.domain.repository.ProductTypeRepository

class ProductTypeRepositoryImpl(
    private val productTypeApi: ProductTypeApi,
    private val converter: ProductTypeConverter
): ProductTypeRepository {
    override suspend fun getAllProductType(): ProductTypeEntity =
        //productTypeApi.getAllProductType().map { converter.convertProductTypeModelInProductTypeEntity(it) }

        converter.convertProductTypeModelInProductTypeEntity(productTypeApi.getAllProductType())
}