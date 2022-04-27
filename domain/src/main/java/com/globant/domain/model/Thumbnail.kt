package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class Thumbnail (
    @SerializedName("path")
    val image: String,
    @SerializedName("extension")
    val extension: String
)