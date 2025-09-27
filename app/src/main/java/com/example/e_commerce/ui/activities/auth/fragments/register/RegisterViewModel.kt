package com.example.e_commerce.ui.activities.auth.fragments.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerce.domain.UseCases.RegisterUseCase
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.ui.uitls.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {

    private val _registerState = MutableLiveData<RegisterState>()
    val registerState: LiveData<RegisterState> = _registerState

    fun register(name: String, phone: String, email: String, password: String) {
        viewModelScope.launch {
            _registerState.value = RegisterState.Loading
            try {
                when (val result = registerUseCase(name, phone, email, password)) {
                    is ApiResult.SuccessApiResult -> _registerState.value = RegisterState.Success
                    is ApiResult.ErrorApiResult -> _registerState.value =
                        RegisterState.Error(result.error ?: "Registration failed")
                }
            } catch (e: Exception) {
                _registerState.value = RegisterState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}




