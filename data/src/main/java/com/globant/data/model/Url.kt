package com.globant.data.model

import com.globant.domain.model.UrlData

data class Url(
    val type: String,
    val url: String
)

fun Url.toUrlData() : UrlData {
    return UrlData(
        type = type,
        url = url
    )
}