package com.example.rent_of_things_app.data.converter

import com.example.rent_of_things_app.data.model.ProductModel
import com.example.rent_of_things_app.domain.entity.ProductEntity

class ProductConverter {
    val productFreeConst = "free"
    val productForRent = "rent"

    fun convertProductModelInEntity(from: ProductModel): ProductEntity =
        ProductEntity(
            productId = from.productId,
            userId = from.userId,
            adType = when(from.adType){
                productForRent -> "Даю в аренду"
                else -> "Ищу в аренду"
                                      },
            productForRent = when(from.adType){
                productForRent -> true
                else -> false
            },
            productName = from.productName,
            productType = from.productType,
            productDescription = from.productDescription,
            address = from.address,
            creationDate = from.creationDate,
            photo = from.photo,
            price = from.price.toString(),
            productAvailable = when(from.status){
                productFreeConst -> true
                else -> false
            }
        )
}