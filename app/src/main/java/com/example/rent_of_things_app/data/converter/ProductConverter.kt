package com.example.rent_of_things_app.data.converter

import com.example.rent_of_things_app.data.model.ProductModel
import com.example.rent_of_things_app.domain.entity.ProductEntity

class ProductConverter {
    fun convertProductModelInEntity(from: ProductModel): ProductEntity =
        ProductEntity(
            productId = from.productId,
            userId = from.userId,
            adType = from.adType,
            productName = from.productName,
            productType = from.productType,
            productDescription = from.productDescription,
            address = from.address,
            creationDate = from.creationDate,
            photo = from.photo,
            price = from.price.toString(),
            status = from.status
        )
}