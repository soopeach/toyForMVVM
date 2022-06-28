package com.soopeach.movietoyproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.soopeach.movietoyproject.databinding.FragmentRankBinding


class RankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRankBinding>(inflater, R.layout.fragment_rank, container, false)

        return binding.root
    }


}