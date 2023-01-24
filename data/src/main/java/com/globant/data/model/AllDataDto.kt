package com.globant.data.model

import com.globant.domain.model.DataObject

data class AllDataDto(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)

fun AllDataDto.toAllData(): DataObject {
    return DataObject(
        mealList = data.toDataObject()
    )
}