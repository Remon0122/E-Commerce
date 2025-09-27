package com.example.e_commerce.ui.activities.auth.fragments.forgetPassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.domain.UseCases.ForgetPasswordUseCase
import com.example.e_commerce.domain.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelForgetPassword @Inject constructor(
    private val forgetPasswordUseCase: ForgetPasswordUseCase
) : ViewModel() {

    val emailLiveData = MutableLiveData<String>()
    val emailError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()

    val successMessage = MutableLiveData<String>()

    val errorMessage = MutableLiveData<String>()

    fun sendPassword() {
        val email = emailLiveData.value.orEmpty()
        if (email.isBlank()) {
            emailError.value = "Email is required"
            return
        }
        emailError.value = null

        viewModelScope.launch {
            loading.value = true
            val result = forgetPasswordUseCase(email)
            loading.value = false
            when (result) {
                is ApiResult.SuccessApiResult -> {
                    successMessage.value = result.data?.message ?: "Check your email"
                }

                is ApiResult.ErrorApiResult -> {
                    errorMessage.value = result.error ?: "Something went wrong"
                }
            }
        }
    }
}

