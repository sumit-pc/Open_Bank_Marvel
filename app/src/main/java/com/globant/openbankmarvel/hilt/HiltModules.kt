package com.globant.openbankmarvel.hilt

import com.globant.data.remote.ApiService
import com.globant.data.repositories.heroes.DetailsImpl
import com.globant.data.repositories.heroes.SearchImpl
import com.globant.domain.repositories.DetailsRepository
import com.globant.domain.repositories.SearchRepository
import com.globant.openbankmarvel.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun provideHeroSearchResult(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }


    @Provides
    fun provideSearchRepository(apiService: ApiService): SearchRepository {
        return SearchImpl(apiService)
    }

    @Provides
    fun provideDetailsRepository(apiService: ApiService): DetailsRepository {
        return DetailsImpl(apiService)
    }

}