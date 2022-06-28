package com.soopeach.movietoyproject.rank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.databinding.FragmentRankBinding


class RankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRankBinding>(inflater,
            R.layout.fragment_rank, container, false)

        binding.setLifecycleOwner(this)
        val rankViewModel = ViewModelProvider(this).get(RankViewModel::class.java)
        binding.viewModel = rankViewModel



        return binding.root
    }


}