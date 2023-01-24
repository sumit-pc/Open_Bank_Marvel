package com.globant.data.model

import com.globant.domain.model.HeroData

data class Result(
    val comics: Comics,
    val description: String,
    val events: Events,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Stories,
    val thumbnail: ThumbnailDTO,
    val urls: List<Url>
)

fun Result.toHeroData() : HeroData {
    return HeroData(
        mealId = id.toString(),
        name = name,
        thumbnail = thumbnail.toThumbnail(),
        urlList = urls.map { it.toUrlData() }
    )
}