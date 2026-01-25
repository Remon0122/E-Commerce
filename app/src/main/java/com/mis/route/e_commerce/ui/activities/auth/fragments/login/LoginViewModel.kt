package com.mis.route.e_commerce.ui.activities.auth.fragments.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.domain.usecases.GetLoginUseCase
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.domain.utils.AppErrors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: GetLoginUseCase
) : ViewModel() {

    val emailLiveData = MutableLiveData<String>("")
    val passwordLiveData = MutableLiveData<String>("")

    val emailError = MutableLiveData<String>("")
    val passwordError = MutableLiveData<String>("")
    private val _loginState = MutableLiveData<ApiResult<TokenResponse>>()
    val loginState: LiveData<ApiResult<TokenResponse>> = _loginState

    fun isLoading() {
        val email = emailLiveData.value.orEmpty()
        val password = passwordLiveData.value.orEmpty()

        if (email.isBlank() || password.isBlank()) {
            _loginState.value = ApiResult.ErrorApiResult(
                AppErrors.NetworkError("Please enter email and password")
            )
            return
        }

        viewModelScope.launch {
            _loginState.value = loginUseCase.execute(email, password)
        }
    }
}


