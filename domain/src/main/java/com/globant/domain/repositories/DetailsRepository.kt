package com.globant.domain.repositories

import com.globant.domain.model.HerosDetails


interface DetailsRepository {

    suspend fun getMealDetails(id: String, pk:String, ts:String, hash:String) : HerosDetails

}