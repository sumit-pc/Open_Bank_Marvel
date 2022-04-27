package com.globant.domain.repositories

import com.globant.domain.model.AllData

interface SearchRepository {

    suspend fun getMealList() : AllData
}