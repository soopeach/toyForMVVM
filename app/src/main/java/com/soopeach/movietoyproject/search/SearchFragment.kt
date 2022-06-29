package com.soopeach.movietoyproject.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.adapters.SearchListAdapter
import com.soopeach.movietoyproject.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSearchBinding>(inflater,
            R.layout.fragment_search, container, false)

        binding.lifecycleOwner = this
        val searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        binding.viewModel = searchViewModel

        val adapter = SearchListAdapter()
        binding.recyclerView.adapter = adapter

        return binding.root
    }

}