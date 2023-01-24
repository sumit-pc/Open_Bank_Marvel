package com.globant.data.model

import com.globant.domain.model.HeroData

data class ResultX(
    val comics: ComicsX,
    val description: String,
    val events: EventsX,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: SeriesX,
    val stories: StoriesX,
    val thumbnail: ThumbnailDTO,
    val urls: List<Url>
)

fun ResultX.toHeroData() : HeroData {
    return HeroData(
        mealId = id.toString(),
        thumbnail = thumbnail.toThumbnail(),
        name = name,
        urlList = urls.map { it.toUrlData() }
    )
}