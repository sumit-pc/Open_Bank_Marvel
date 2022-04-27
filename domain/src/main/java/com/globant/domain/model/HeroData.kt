package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class HeroData(
    @SerializedName("id")
    val mealId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail,
    @SerializedName("urls")
    val urlList: List<UrlData> = listOf()
)