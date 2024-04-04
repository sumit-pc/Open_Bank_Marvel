package com.globant.openbankmarvel.hilt

import com.globant.data.remote.ApiService
import com.globant.data.repositories.heroes.DetailsImpl
import com.globant.data.repositories.heroes.SearchImpl
import com.globant.domain.repositories.DetailsRepository
import com.globant.domain.repositories.SearchRepository
import com.globant.openbankmarvel.BuildConfig
import com.globant.openbankmarvel.common.HashClass
import com.globant.openbankmarvel.common.HashClass.Companion.toHex
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModules {

    @Provides
    @Singleton
    fun provideHeroSearchResult(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
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

    @Provides
    @Singleton
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val timeStamp = System.currentTimeMillis().toString()
            val builder = chain.request().url.newBuilder()
            val url = builder
                .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
                .addQueryParameter("ts", timeStamp)
                .addQueryParameter("hash", HashClass.md5(timeStamp,
                    BuildConfig.PRIVATE_KEY,
                    BuildConfig.PUBLIC_KEY).toHex())
                .build()
            return@Interceptor chain.proceed(chain.request().newBuilder().url(url).build())
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

}