package com.example.rent_of_things_app.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id")
    var productId: String,
    @SerializedName("user_id")
    var userId: String,
    @SerializedName("ad_type")
    var adType: String,
    @SerializedName("product_name")
    var productName: String,
    @SerializedName("product_type")
    var productType: String,
    @SerializedName("product_description")
    var productDescription: String,
    @SerializedName("address")
    var address: String,
    @SerializedName("creation_date")
    var creationDate: String,
    @SerializedName("photo")
    var photo: String,
    @SerializedName("price")
    var price: Int,
    @SerializedName("status")
    var status: String
)
