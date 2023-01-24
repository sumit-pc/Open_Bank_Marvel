package com.globant.data.repositories.heroes

import com.globant.data.model.toAllData
import com.globant.data.remote.ApiService
import com.globant.domain.model.DataObject
import com.globant.domain.repositories.SearchRepository


class SearchImpl(private val apiService: ApiService): SearchRepository {

    override suspend fun getHerosList(pk:String, ts:String, hash:String): DataObject {
         return apiService.getMealList(apikey = pk, ts, hash).toAllData()
    }

}