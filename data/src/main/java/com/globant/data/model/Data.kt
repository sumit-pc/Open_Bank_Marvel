package com.globant.data.model

import com.globant.domain.model.HeroData

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)

fun Data.toDataObject() : List<HeroData> {
    return results.map { it.toHeroData() }
}