package com.globant.data.repositories.heroes

import com.globant.data.remote.ApiService
import com.globant.domain.model.AllData
import com.globant.domain.repositories.SearchRepository


class SearchImpl(private val apiService: ApiService): SearchRepository {

    override suspend fun getMealList(pk:String, ts:String, hash:String): AllData {
         return apiService.getMealList(apikey = pk, ts, hash)
    }

}