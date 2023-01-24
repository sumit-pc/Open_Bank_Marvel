package com.globant.data.model

data class ComicsX(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)