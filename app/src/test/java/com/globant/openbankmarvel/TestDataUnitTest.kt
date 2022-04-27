package com.globant.openbankmarvel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.globant.domain.common.ApiState
import com.globant.domain.usecases.GetSearchList
import com.globant.openbankmarvel.repositories.FakeSearchRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `insert all data and not get any error responce`() {

        val fakeSearchRepository = FakeSearchRepository()
        val getSearchList = GetSearchList(fakeSearchRepository)

        assertThat(getSearchList.invoke("test", "test", "test").let { it }).isNotEqualTo(ApiState.Error("",""))
    }

    @Test
    fun `insert data and get sucess responce`() {

        val fakeSearchRepository = FakeSearchRepository()
        val getSearchList = GetSearchList(fakeSearchRepository)

        assertThat(getSearchList.invoke("test", "test", "test").let { it }).isNotEqualTo(ApiState.Success(""))
    }

}