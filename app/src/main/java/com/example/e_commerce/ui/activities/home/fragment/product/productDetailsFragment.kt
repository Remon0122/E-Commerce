package com.example.e_commerce.ui.activities.home.fragment.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerce.databinding.FragmentProductDetailsBinding

class productDetailsFragment : Fragment() {
    private var _binding : FragmentProductDetailsBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }
}