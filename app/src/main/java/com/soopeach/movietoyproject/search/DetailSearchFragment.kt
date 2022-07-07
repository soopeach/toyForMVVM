package com.soopeach.movietoyproject.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.databinding.FragmentDetailSearchBinding

class DetailSearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailSearchBinding>(inflater,R.layout.fragment_detail_search, container,false)
        val application = requireNotNull(activity).application
        binding.lifecycleOwner = this

        val item = DetailSearchFragmentArgs.fromBundle(requireArguments()).item
        val viewModelFactory = DetailSearchViewModelFactory(item, application)
        val searchDetailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailSearchViewModel::class.java)

        binding.viewModel = searchDetailViewModel

        return binding.root
    }

}