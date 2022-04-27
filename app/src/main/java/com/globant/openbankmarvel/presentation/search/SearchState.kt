package com.globant.openbankmarvel.presentation.search

import com.globant.domain.model.HeroData

data class SearchState(
    val data: List<HeroData>? = null,
    val error: String = "",
    val isLoading: Boolean = false
)




