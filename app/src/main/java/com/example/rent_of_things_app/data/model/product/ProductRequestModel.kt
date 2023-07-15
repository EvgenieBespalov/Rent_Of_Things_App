package com.example.rent_of_things_app.data.model.product

import com.google.gson.annotations.SerializedName

data class ProductRequestModel(
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
    @SerializedName("photo")
    var photo: String,
    @SerializedName("price")
    var price: Int,
    @SerializedName("timeframe")
    var timeFrame: String
)