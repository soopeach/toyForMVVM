package com.soopeach.movietoyproject.rank

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.databinding.FragmentDetailRankBinding

class DetailRankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailRankBinding>(inflater, R.layout.fragment_detail_rank, container, false)
        val application = requireNotNull(activity).application
        binding.lifecycleOwner = viewLifecycleOwner

        val movieCd = DetailRankFragmentArgs.fromBundle(requireArguments()).movieCd
        
        val viewModelFactory = DetailRankViewModelFactory(movieCd, application)
        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(DetailRankViewModel::class.java)

        return binding.root
    }


}