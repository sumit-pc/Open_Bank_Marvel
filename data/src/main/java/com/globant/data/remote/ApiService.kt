package com.globant.data.remote

import com.globant.data.model.AllDataDto
import com.globant.data.model.HerosDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("public/characters")
    suspend fun getMealList(): AllDataDto

    @GET("public/characters/{id}")
    suspend fun getMealDetails(@Path("id") groupId: String): HerosDetailsDto
}