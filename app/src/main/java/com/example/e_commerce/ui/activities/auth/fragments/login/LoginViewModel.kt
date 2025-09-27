package com.example.e_commerce.ui.activities.auth.fragments.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.domain.UseCases.LoginUseCase
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.ui.uitls.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val loginApiState = MutableLiveData<Resource<TokenResponse>>(Resource.IdleState())
    var emailLiveData = MutableLiveData("")
    var passwordLiveData = MutableLiveData("")
    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()

    fun login() {
        Log.e("LoginViewModel", "login click")
        viewModelScope.launch {
            when (val result = loginUseCase.execute(
                emailLiveData.value!!,
                passwordLiveData.value!!
            )) {
                is ApiResult.ErrorApiResult -> {
                    Log.e("LoginViewModel", "ErrorApiResult -> ${result.error}")
                    loginApiState.postValue(Resource.ErrorState(result.error!!))
                }

                is ApiResult.SuccessApiResult -> {
                    Log.e("LoginViewModel", "SuccessApiResult -> ${result.data}")
                    loginApiState.postValue(Resource.SuccessState(result.data!!))
                }
            }
        }
    }
}
