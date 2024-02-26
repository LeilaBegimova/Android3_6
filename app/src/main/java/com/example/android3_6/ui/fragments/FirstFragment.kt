package com.example.android3_6.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android3_6.R
import com.example.android3_6.databinding.FragmentFirstBinding
import com.example.android3_6.ui.activity.ViewModels
import com.example.android3_6.ui.adapter.JsonAdapter


class FirstFragment : Fragment() {
    private var _binding:FragmentFirstBinding? = null
    private val binding:FragmentFirstBinding get() = _binding!!
    private val adapter = JsonAdapter()
    private val  viewModel by activityViewModels<ViewModels>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        initialize()
        Log.e("room", "onViewCreated: ${viewModel.fetchData()}", )
        adapter.setJson(viewModel.fetchData())
    }

    private fun initialize() {
        binding.rvItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItem.adapter = adapter

    }

    private fun setupListeners() {
        binding.arrow.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}