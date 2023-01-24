package com.globant.data.remote

import com.globant.data.model.AllDataDto
import com.globant.data.model.HerosDetailsDto
import com.globant.domain.model.AllData
import com.globant.domain.model.HerosDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("public/characters")
    suspend fun getMealList(@Query("apikey") apikey:String,
                            @Query("ts") ts:String,
                            @Query("hash") hash:String
    ): AllDataDto

    @GET("public/characters/{id}")
    suspend fun getMealDetails(@Path("id") groupId:String ,
                               @Query("apikey") apikey:String,
                               @Query("ts") ts:String,
                               @Query("hash") hash:String
    ): HerosDetailsDto

}