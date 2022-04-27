package com.globant.openbankmarvel.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.common.ApiState
import com.globant.domain.usecases.GetDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getDetails: GetDetails): ViewModel() {

    private val _heroDetails = MutableStateFlow<DetailState>(DetailState())
    val heroDetails: StateFlow<DetailState> = _heroDetails

    fun getMealDetails(id: String) {
        getDetails(id).onEach {
            when(it) {
                is ApiState.Loading -> {
                    _heroDetails.value = DetailState(isLoading = true)
                }
                is ApiState.Success -> {
                    _heroDetails.value = DetailState(data = it.data)
                }
                is ApiState.Error -> {
                    _heroDetails.value = DetailState(error = it.message?:"")
                }
            }
        }.launchIn(viewModelScope)
    }


}