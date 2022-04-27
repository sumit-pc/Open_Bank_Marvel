package com.globant.data.remote

import com.globant.domain.model.AllData
import com.globant.domain.model.HerosDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("public/characters")
    suspend fun getMealList(@Query("apikey") apikey:String="00fb521e8a8cf4cad2f5ba2243776e70",
                            @Query("ts") ts:String="123456789",
                            @Query("hash") hash:String="8dbccc8918c2c03247869a5a3137cac6"
    ): AllData

    @GET("public/characters/{id}")
    suspend fun getMealDetails(@Path("id") groupId:String ,
                               @Query("apikey") apikey:String="00fb521e8a8cf4cad2f5ba2243776e70",
                               @Query("ts") ts:String="123456789",
                               @Query("hash") hash:String="8dbccc8918c2c03247869a5a3137cac6"
    ): HerosDetails

}