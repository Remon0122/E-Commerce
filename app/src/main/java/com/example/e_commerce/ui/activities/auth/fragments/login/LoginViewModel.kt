package com.example.e_commerce.ui.activities.auth.fragments.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.domain.usecases.LoginUseCase
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val emailLiveData = MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")

    val emailError = MutableLiveData<String>("")
    val passwordError = MutableLiveData<String>("")
    private val _loginState = MutableLiveData<ApiResult<Unit>>()
    val loginState: LiveData<ApiResult<Unit>> = _loginState

    fun login() {
        val email = emailLiveData.value.orEmpty()
        val password = passwordLiveData.value.orEmpty()

        if (email.isBlank() || password.isBlank()) {
            _loginState.value = ApiResult.ErrorApiResult(
                AppErrors.NetworkError("Please enter email and password")
            )
            return
        }

        viewModelScope.launch {
            _loginState.value = ApiResult.Loading()
            _loginState.value = loginUseCase.execute(email, password)
        }
    }
}


