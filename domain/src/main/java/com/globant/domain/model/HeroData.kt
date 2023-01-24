package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class HeroData(
    val mealId: String,
    val name: String,
    val thumbnail: Thumbnail,
    val urlList: List<UrlData> = listOf()
)