package com.example.rent_of_things_app.domain.entity

import android.media.Image

data class ProductEntity(
    var productId: String,
    var userId: String,
    var adType: String,
    var productName: String,
    var productType: String,
    var productDescription: String,
    var address: String,
    var creationDate: String,
    var photo: String,
    var price: String,
    var status: String
)
