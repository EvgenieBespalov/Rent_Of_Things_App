package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.entity.ProductTypeEntity
import com.example.rent_of_things_app.domain.repository.ProductTypeRepository

class GetProductTypeUseCase(
    private val repository: ProductTypeRepository
) {
    suspend operator fun invoke(): ProductTypeEntity = repository.getAllProductType()
}