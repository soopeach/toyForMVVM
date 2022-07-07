package com.soopeach.movietoyproject.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.adapters.SearchListAdapter
import com.soopeach.movietoyproject.adapters.SearchOnClickListener
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

        val adapter = SearchListAdapter(SearchOnClickListener {
            searchViewModel.setSelectedItem(item = it)
        })

        searchViewModel.selectedItem.observe(viewLifecycleOwner, Observer{
            it?.let{
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToDetailSearchFragment(it)
                )
                searchViewModel.initSelectedItem()
            }

        })

        binding.recyclerView.adapter = adapter

        return binding.root
    }

}