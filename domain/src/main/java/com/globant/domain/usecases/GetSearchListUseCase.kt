package com.globant.domain.usecases

import com.globant.domain.common.ApiState
import com.globant.domain.common.Loading
import com.globant.domain.model.HeroData
import com.globant.domain.repositories.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

class GetSearchListUseCase @Inject constructor(private val repository: SearchRepository) {

    operator fun invoke(pk:String, ts:String, hash:String): Flow<ApiState<List<HeroData>>> = flow {
        try {
            emit(Loading())

            val response = repository.getHerosList(pk, ts, hash)
            val list = if (response.mealList.isEmpty()) emptyList<HeroData>() else response.mealList.map { it }

            emit(ApiState.Success(list))

        } catch (ex: HttpException) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Unknown Error"))
        } catch (ex: IOException) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Check Internet"))
        } catch (ex: Exception) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Unknown Error "))
        }
    }

}