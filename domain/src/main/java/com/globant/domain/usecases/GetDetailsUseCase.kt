package com.globant.domain.usecases

import com.globant.domain.common.ApiState
import com.globant.domain.common.Loading
import com.globant.domain.model.HeroData
import com.globant.domain.repositories.DetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject


class GetDetailsUseCase @Inject constructor(private val repository: DetailsRepository) {

    operator fun invoke(id: String, pk:String, ts:String, hash:String): Flow<ApiState<HeroData>> = flow {
        try {
            emit(Loading())

            val response = repository.getMealDetails(id, pk, ts, hash).dataObject.mealList[0]

            emit(ApiState.Success(data = response))

        } catch (ex: HttpException) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Unknown Error"))
        } catch (ex: IOException) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Check Internet"))
        } catch (ex: Exception) {
            emit(ApiState.Error(message = ex.localizedMessage?: "Unknown Error "))
        }
    }


}