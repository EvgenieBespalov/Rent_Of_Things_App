package com.example.rent_of_things_app.data.model.product

import com.google.gson.annotations.SerializedName
import java.util.*

data class ProductAnswerModel(
    @SerializedName("id")
    var productId: String,
    @SerializedName("user_id")
    var userId: String?,
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
    var creationDate: Date,
    @SerializedName("photo")
    var photo: String,
    @SerializedName("price")
    var price: String,
    @SerializedName("timeframe")
    var timeFrame: String
)