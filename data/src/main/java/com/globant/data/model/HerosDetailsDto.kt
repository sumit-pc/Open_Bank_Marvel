package com.globant.data.model

import com.globant.domain.model.HerosDetails

data class HerosDetailsDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: DataX,
    val etag: String,
    val status: String
)

fun HerosDetailsDto.toHerosDetails() : HerosDetails {
    return HerosDetails(
        dataObject = data.toHeroData()
    )
}