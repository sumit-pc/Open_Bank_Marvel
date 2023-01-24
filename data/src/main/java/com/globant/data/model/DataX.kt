package com.globant.data.model

import com.globant.domain.model.DataObject

data class DataX(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultX>,
    val total: Int
)

fun DataX.toHeroData() : DataObject {
    return DataObject(
        mealList = results.map { it.toHeroData() }
    )
}