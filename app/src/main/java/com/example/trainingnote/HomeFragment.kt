package com.example.trainingnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trainingnote.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =HomeFragment()
    }
}