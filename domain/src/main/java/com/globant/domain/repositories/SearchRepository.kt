package com.globant.domain.repositories

import com.globant.domain.model.DataObject

interface SearchRepository {

    suspend fun getHerosList(pk:String, ts:String, hash:String) : DataObject
}