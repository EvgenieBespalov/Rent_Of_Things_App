package com.example.rent_of_things_app.data.model

import com.google.gson.annotations.SerializedName

data class ProductTypeModel(
    @SerializedName("product_type")
    val productName: String
)