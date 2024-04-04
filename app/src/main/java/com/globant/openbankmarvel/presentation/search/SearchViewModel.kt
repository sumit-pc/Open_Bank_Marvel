package com.globant.openbankmarvel.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.common.ApiState
import com.globant.domain.common.Loading
import com.globant.domain.usecases.GetSearchListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSearchListUseCase: GetSearchListUseCase
): ViewModel() {

    private val _searchList = MutableStateFlow<SearchState>(SearchState())
    val searchList: StateFlow<SearchState> = _searchList

    fun searchHero(pk: String, ts:String, hash:String ) {
        getSearchListUseCase(pk, ts, hash).onEach {
            when(it) {
                is Loading -> {
                    _searchList.value = SearchState(isLoading = true)
                }
                is ApiState.Success -> {
                    _searchList.value = SearchState(data = it.data)
                }
                is ApiState.Error -> {
                    _searchList.value = SearchState(error = it.message?:"")
                }
            }
        }.launchIn(viewModelScope)
    }
}