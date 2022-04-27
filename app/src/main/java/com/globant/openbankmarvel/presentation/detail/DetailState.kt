package com.globant.openbankmarvel.presentation.detail

import com.globant.domain.model.HeroData

data class DetailState(
    val data: HeroData? = null,
    val error: String = "",
    val isLoading: Boolean = false
) {
}