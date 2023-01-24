package com.globant.data.model

import com.globant.domain.model.DataObject

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)

fun Data.toDataObject() : DataObject {
    return DataObject(results.map { it.toHeroData() })
}