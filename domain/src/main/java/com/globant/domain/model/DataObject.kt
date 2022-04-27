package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("results")
    val mealList: List<HeroData> = listOf()
)
