package com.globant.domain.repositories

import com.globant.domain.model.AllData

interface SearchRepository {

    suspend fun getMealList(pk:String, ts:String, hash:String) : AllData
}