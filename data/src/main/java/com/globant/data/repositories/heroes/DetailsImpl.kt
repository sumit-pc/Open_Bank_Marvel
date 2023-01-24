package com.globant.data.repositories.heroes

import com.globant.data.model.toHerosDetails
import com.globant.data.remote.ApiService
import com.globant.domain.model.HerosDetails
import com.globant.domain.repositories.DetailsRepository


class DetailsImpl(private val apiService: ApiService): DetailsRepository {

    override suspend fun getMealDetails(id: String, pk:String, ts:String, hash:String): HerosDetails {
        return apiService.getMealDetails(id,pk, ts, hash).toHerosDetails()
    }

}
