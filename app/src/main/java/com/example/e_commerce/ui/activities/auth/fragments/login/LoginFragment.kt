package com.example.e_commerce.ui.activities.auth.fragments.login


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.e_commerce.ui.activities.home.fragments.HomeActivity
import com.example.e_commerce.databinding.FragmentLoginBinding
import com.example.e_commerce.R
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val  loginViewModel by viewModels<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this
        initListeners()
        setupObservers()
        initRegister()
    }

    private fun setupObservers() {
        loginViewModel.loginState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ApiResult.Loading -> showLoading(true)
                is ApiResult.SuccessApiResult -> {
                    showLoading(false)
                    startHomeActivity()
                }
                is ApiResult.ErrorApiResult -> {
                    showLoading(false)
                    showError(state.error)
                }
                else -> showLoading(false)
            }
        }
    }

    private fun initListeners() {
        binding.loginBtn.setOnClickListener {
            loginViewModel.login()
        }

        binding.donTHaveAnAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }


    private fun startHomeActivity() {
        val intent = Intent(requireContext(), HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            dialog = ProgressDialog(requireContext())
            dialog!!.show()
        } else {
            dialog?.dismiss()
        }
    }

    var dialog: ProgressDialog? = null
    private fun showError(error: AppErrors) {
        Toast.makeText(requireContext(), error.errorMessage, Toast.LENGTH_LONG)
            .show()
    }
    private fun initRegister() {
        binding.donTHaveAnAccountTv.setOnClickListener {
            findNavController()
                .navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}