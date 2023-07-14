package com.example.rent_of_things_app.domain.repository

import com.example.rent_of_things_app.domain.entity.ProductTypeEntity

interface ProductTypeRepository {
    suspend fun getAllProductType(): ProductTypeEntity
}