package com.mis.route.e_commerce.ui.activities.auth.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.domain.model.request.RegisterRequest
import com.mis.route.e_commerce.domain.usecases.GetRegisterUseCase
import com.mis.route.e_commerce.domain.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: GetRegisterUseCase
) : ViewModel() {

    val nameLiveData = MutableLiveData<String>("")
    val emailLiveData = MutableLiveData<String>("")
    val phoneLiveData = MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")
    val confirmPasswordLiveData = MutableLiveData<String>("")

    // أخطاء لكل حقل
    val nameError = MutableLiveData<String?>()
    val emailError = MutableLiveData<String?>()
    val phoneError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()
    val confirmPasswordError = MutableLiveData<String?>()

    val isLoading = MutableLiveData(false)

    private val _registerState = MutableLiveData<ApiResult<TokenResponse>>()
    val registerState: LiveData<ApiResult<TokenResponse>> = _registerState

    fun register() {
        // تنظيف الأخطاء السابقة
        nameError.value = null
        emailError.value = null
        phoneError.value = null
        passwordError.value = null
        confirmPasswordError.value = null

        val name = nameLiveData.value.orEmpty()
        val email = emailLiveData.value.orEmpty()
        val phone = phoneLiveData.value.orEmpty()
        val password = passwordLiveData.value.orEmpty()
        val confirmPassword = confirmPasswordLiveData.value.orEmpty()

        var hasError = false

        if (name.isBlank()) {
            nameError.value = "Name is required"
            hasError = true
        }
        if (email.isBlank()) {
            emailError.value = "Email is required"
            hasError = true
        }
        if (phone.isBlank()) {
            phoneError.value = "Phone is required"
            hasError = true
        }
        if (password.isBlank()) {
            passwordError.value = "Password is required"
            hasError = true
        }
        if (confirmPassword.isBlank()) {
            confirmPasswordError.value = "Confirm password is required"
            hasError = true
        }
        if (password.isNotBlank() && confirmPassword.isNotBlank() && password != confirmPassword) {
            confirmPasswordError.value = "Passwords do not match"
            hasError = true
        }

        if (hasError) return

        val request = RegisterRequest(
            name = name,
            email = email,
            phone = phone,
            password = password,
            rePassword = confirmPassword
        )

        viewModelScope.launch {
            isLoading.value = true
            when (val result = registerUseCase.execute(request)) {
                is ApiResult.SuccessApiResult -> _registerState.value = result
                is ApiResult.ErrorApiResult -> _registerState.value = result
            }
            isLoading.value = false
        }
    }
}


