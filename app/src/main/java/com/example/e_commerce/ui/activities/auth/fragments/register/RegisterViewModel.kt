package com.example.e_commerce.ui.activities.auth.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.data.models.request.RegisterRequest
import com.example.e_commerce.domain.usecases.RegisterUseCase
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    val nameLiveData = MutableLiveData<String>("")
    val emailLiveData = MutableLiveData<String>("")
    val phoneLiveData = MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")
    val confirmPasswordLiveData = MutableLiveData<String>("")

    private val _registerState = MutableLiveData<ApiResult<Unit>>()
    val registerState: LiveData<ApiResult<Unit>> = _registerState

    fun register() {
        val name = nameLiveData.value.orEmpty()
        val email = emailLiveData.value.orEmpty()
        val phone = phoneLiveData.value.orEmpty()
        val password = passwordLiveData.value.orEmpty()
        val confirmPassword = confirmPasswordLiveData.value.orEmpty()


        if (name.isBlank() || email.isBlank() || phone.isBlank()
            || password.isBlank() || confirmPassword.isBlank()
        ) {
            _registerState.value =
                ApiResult.ErrorApiResult(AppErrors.ValidationError("All fields are required"))
            return
        }

        if (password != confirmPassword) {
            _registerState.value =
                ApiResult.ErrorApiResult(AppErrors.ValidationError("Passwords do not match"))
            return
        }

        val request = RegisterRequest(
            name = name,
            email = email,
            phone = phone,
            password = password,
            rePassword = confirmPassword
        )

        viewModelScope.launch {
            _registerState.value = ApiResult.Loading()
            _registerState.value = registerUseCase.execute(request)
        }
    }
}

