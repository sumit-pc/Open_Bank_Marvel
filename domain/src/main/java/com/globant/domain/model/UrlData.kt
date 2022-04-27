package com.globant.domain.model

import com.google.gson.annotations.SerializedName

data class UrlData (
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)

