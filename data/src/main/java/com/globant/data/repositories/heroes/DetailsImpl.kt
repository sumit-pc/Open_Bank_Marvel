package com.globant.data.repositories.heroes

import com.globant.data.remote.ApiService
import com.globant.domain.model.HerosDetails
import com.globant.domain.repositories.DetailsRepository


class DetailsImpl(private val apiService: ApiService): DetailsRepository {

    override suspend fun getMealDetails(id: String): HerosDetails {
        return apiService.getMealDetails(id)
    }

}
