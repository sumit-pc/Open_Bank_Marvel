package com.globant.domain.repositories

import com.globant.domain.model.AllData

interface SearchRepository {

    suspend fun getHerosList(pk:String, ts:String, hash:String) : AllData
}