package com.globant.data.model

import com.globant.domain.model.Thumbnail

data class ThumbnailDTO(
    val extension: String,
    val path: String
)

fun ThumbnailDTO.toThumbnail() : Thumbnail {
    return Thumbnail(
        image = path,
        extension = extension
    )
}