package com.globant.openbankmarvel.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.globant.domain.model.HeroData
import com.globant.openbankmarvel.BuildConfig
import com.globant.openbankmarvel.common.HashClass
import com.globant.openbankmarvel.common.HashClass.Companion.toHex
import com.globant.openbankmarvel.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding!!

    private val detailsViewModel: DetailViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var mealId: String
    private lateinit var herosDetails: HeroData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.mealId?.let { id ->
            mealId = id
            val ts = System.currentTimeMillis().toString()
            detailsViewModel.getMealDetails(id, BuildConfig.PUBLIC_KEY, ts, HashClass.md5(ts,
                BuildConfig.PRIVATE_KEY,
                BuildConfig.PUBLIC_KEY).toHex())
        }

        binding.detailsBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }



        lifecycle.coroutineScope.launchWhenCreated {
            detailsViewModel.heroDetails.collect {
                if (it.error.isNotBlank()) {
                    Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                }

                it.data?.let { data ->
                    herosDetails = data
                    binding.mealDetails = data
                }
            }
        }

    }

}