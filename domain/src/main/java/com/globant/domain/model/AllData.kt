package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class AllData(
    @SerializedName("data")
    val dataObject: DataObject
)

