package com.example.rent_of_things_app.domain.usecase

import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.example.rent_of_things_app.domain.repository.ProductRepository

class GetProductByUserIDUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(userId: String): List<ProductEntity> = repository.getProductByUserId(userId)
}