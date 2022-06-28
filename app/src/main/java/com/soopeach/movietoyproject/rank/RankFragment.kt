package com.soopeach.movietoyproject.rank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.adapters.RankListAdapter
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

        // 검색결과가 없다면 경고창 출력.
        rankViewModel.listEmpty.observe(viewLifecycleOwner, Observer { isEmpty ->
            if (isEmpty){
                Toast.makeText(context, "검색 결과가 없습니다.", Toast.LENGTH_SHORT).show()
                rankViewModel.listInit()
            }
        })

        val adapter = RankListAdapter()
        binding.recyclerView.adapter = adapter

        return binding.root
    }


}