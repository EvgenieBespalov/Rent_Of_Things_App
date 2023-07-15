package com.example.rent_of_things_app.data.converter

import com.example.rent_of_things_app.data.model.product.ProductAnswerModel
import com.example.rent_of_things_app.data.model.product.ProductModel
import com.example.rent_of_things_app.data.model.product.ProductRequestModel
import com.example.rent_of_things_app.domain.entity.ProductEntity
import com.google.gson.annotations.SerializedName

class ProductConverter {
    private val productFreeConst = "free"
    private val productForRent = "rent"

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
            },
            timeFrame = when(from.timeFrame){
                "day" -> "день"
                "week" -> "неделя"
                "hour" -> "час"
                else -> ""
            }
        )

    fun convertProductEntityInProductRequestModel(from: ProductEntity): ProductRequestModel =
        ProductRequestModel(
            adType = from.adType,
            productName = from.productName,
            productType = from.productType,
            productDescription = from.productDescription,
            address = from.address,
            photo = from.photo,
            price = from.price.toInt(),
            timeFrame = from.timeFrame
        )

    fun convertProductAnswerModelInProductEntity(from: ProductAnswerModel): ProductEntity =
        ProductEntity(
            productId = from.productId,
            productName = from.productName,
            productType = from.productType,
            productDescription = from.productDescription,
            address = from.address,
            photo = from.photo,
            price = from.price,
            timeFrame = when(from.timeFrame){
                "day" -> "день"
                "week" -> "неделя"
                "hour" -> "час"
                else -> ""
            },
            adType = when(from.adType){
                productForRent -> "Даю в аренду"
                else -> "Ищу в аренду"
            },
            productForRent = when(from.adType){
                productForRent -> true
                else -> false
            },
            creationDate = from.creationDate.toString(),
            productAvailable = true,
            userId = from.userId
        )
}