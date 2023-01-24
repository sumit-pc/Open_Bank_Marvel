package com.globant.data.model

data class EventsX(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)