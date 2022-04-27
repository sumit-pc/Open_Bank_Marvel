package com.globant.openbankmarvel.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.globant.openbankmarvel.BuildConfig
import com.globant.openbankmarvel.R
import com.globant.openbankmarvel.common.HashClass
import com.globant.openbankmarvel.common.HashClass.Companion.toHex
import com.globant.openbankmarvel.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding!!

    private val searchViewModel: SearchViewModel by viewModels()
    private val searchAdapter = SearchAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ts = System.currentTimeMillis().toString()
        searchViewModel.searchHero(BuildConfig.PUBLIC_KEY, ts, HashClass.md5(ts,BuildConfig.PRIVATE_KEY,BuildConfig.PUBLIC_KEY).toHex())

        binding.heroSearchRecycler.apply {
            adapter = searchAdapter
        }

        lifecycle.coroutineScope.launchWhenCreated {
            searchViewModel.searchList.collect {
                if (it.isLoading) {
                    binding.nothingFound.visibility = View.GONE
                    binding.progressMealSearch.visibility = View.VISIBLE }
                if (it.error.isNotBlank()) {
                    binding.progressMealSearch.visibility = View.GONE
                    binding.nothingFound.visibility = View.VISIBLE
                }

                it.data?.let { list ->
                    binding.progressMealSearch.visibility = View.GONE
                    searchAdapter.setContentList(list.toMutableList())
                }
            }
        }

        searchAdapter.itemClickListener {
            if (findNavController().currentDestination?.id == R.id.searchFragment) {
                findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToDetailsFragment(mealId = it.mealId))
            }
        }
    }

}