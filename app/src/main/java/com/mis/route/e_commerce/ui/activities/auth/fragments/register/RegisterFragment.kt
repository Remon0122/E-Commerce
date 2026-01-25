package com.mis.route.e_commerce.ui.activities.auth.fragments.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.databinding.FragmentRegisterBinding
import com.mis.route.e_commerce.domain.utils.ApiResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel : RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setupObservers()
    }

    private fun initListeners() {
        binding.registerBtn.setOnClickListener {
            viewModel.register()
        }

        binding.loginDoHaveAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun setupObservers() {
        viewModel.registerState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ApiResult.SuccessApiResult -> {
                    binding.progressBar.visibility = View.GONE
                    binding.registerBtn.isEnabled = true
                    Toast.makeText(requireContext(), "Registered successfully", Toast.LENGTH_SHORT).show()
                    findNavController()
                        .navigate(R.id.action_registerFragment_to_loginFragment)
                }

                is ApiResult.ErrorApiResult -> {
                    binding.progressBar.visibility = View.GONE
                    binding.registerBtn.isEnabled = true
                    Toast.makeText(
                        requireContext(),
                        state.error.errorMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}