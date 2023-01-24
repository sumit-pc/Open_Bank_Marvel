package com.globant.data.model

import com.globant.domain.model.AllData

data class AllDataDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)

fun AllDataDto.toAllData(): AllData {
    return AllData(
        dataObject = data.toDataObject()
    )
}