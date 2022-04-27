package com.globant.data.repositories.heroes

import com.globant.data.remote.ApiService
import com.globant.domain.model.AllData
import com.globant.domain.repositories.SearchRepository


class SearchImpl(private val apiService: ApiService): SearchRepository {

    override suspend fun getMealList(): AllData {
         return apiService.getMealList()
    }

}