package com.example.e_commerce.ui.activates.auth.fragments.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.domain.UseCases.loginUseCase
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.ui.uitls.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val loginUseCase: loginUseCase) : ViewModel() {

    val loginApiState = MutableLiveData<Resource<Unit>>(Resource.IdleState())
    var emailLiveData = MutableLiveData("")
    var passwordLiveData = MutableLiveData("")
    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()

    fun login(){
        viewModelScope.launch{
            Log.e("LoginViewModel","Login Click")
            when (val result = loginUseCase.execute(
                emailError.value!!,
                passwordError.value!!
            )){
                is ApiResult.ErrorApiResult ->{
                    Log.e("LoginViewModel", "ErrorApiResult -> ${result.error}")
                    loginApiState.postValue(Resource.ErrorState(result.error))
                }
                is ApiResult.SuccessApiResult ->{
                    Log.e("loginViewModel","ErrorApiResult")
                    loginApiState.postValue(Resource.SuccessState())
                }
            }
        }
    }

}