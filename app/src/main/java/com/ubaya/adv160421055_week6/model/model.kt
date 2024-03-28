package com.ubaya.adv160421055_week6.model

import com.google.gson.annotations.SerializedName

data class motorcycle(
    val id:Int?,
    val brand:String?,
    val model:String?,
    val year:Int?,
    val engine: engine,
    @SerializedName("color") val colors: List<String>?,
    val price: Int?,
    @SerializedName("photo_url") val images: String?
)
data class engine(
    val type: String?,
    val displacement: String?
)