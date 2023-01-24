package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class DataObject(
    val mealList: List<HeroData> = listOf()
)
