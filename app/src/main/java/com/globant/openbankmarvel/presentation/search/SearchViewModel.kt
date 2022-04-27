package com.globant.openbankmarvel.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.common.ApiState
import com.globant.domain.usecases.GetSearchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getSearchList: GetSearchList): ViewModel() {

    private val _searchList = MutableStateFlow<SearchState>(SearchState())
    val searchList: StateFlow<SearchState> = _searchList

    fun searchHero(pk: String, ts:String, hash:String ) {

        getSearchList(pk, ts, hash).onEach {
            when(it) {
                is ApiState.Loading -> {
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