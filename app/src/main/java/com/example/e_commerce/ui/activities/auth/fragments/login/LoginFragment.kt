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
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentLoginBinding
import com.example.e_commerce.ui.activities.home.HomeActivity
import com.example.e_commerce.ui.uitls.PrefsManager
import com.example.e_commerce.ui.uitls.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel by viewModels<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var dialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = loginViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        initListeners()
        setupObservers()
    }

    private fun initListeners() {
        // زر تسجيل الدخول
        binding.loginBtn.setOnClickListener {
            loginViewModel.login()
        }

        // زر "Don't have an account? Sign up"
        binding.donTHaveAnAccountTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.forgetPasswordFragment)
        }

    }

    private fun setupObservers() {
        loginViewModel.loginApiState.observe(viewLifecycleOwner) { state ->
            showLoading(state is Resource.LoadingState)
            when (state) {
                is Resource.ErrorState -> showError(state.error)
                is Resource.SuccessState -> {
                    // 🟢 أول ما يحصل نجاح
                    PrefsManager.saveLoginTime(requireContext())

                    // بعد كده روح على الـ Home
                    startHomeActivity()
                }
                else -> {}
            }
        }
    }

    private fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
    }

    private fun startHomeActivity() {
        val intent = Intent(requireContext(), HomeActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            if (dialog == null) {
                dialog = ProgressDialog(requireContext())
                dialog!!.setMessage("Loading...")
                dialog!!.setCancelable(false)
            }
            dialog!!.show()
        } else {
            dialog?.dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
