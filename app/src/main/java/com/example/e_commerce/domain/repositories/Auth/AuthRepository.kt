package com.example.e_commerce.domain.repositories.Auth

import com.example.e_commerce.data.api.model.repassword.ForgetPasswordResponse
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.domain.register.RegisterRequest
import com.example.e_commerce.domain.utils.ApiResult

interface AuthRepository {
     suspend fun login(email: String, password: String): ApiResult<TokenResponse>
     suspend fun register(registerRequest: RegisterRequest): ApiResult<TokenResponse>
     suspend fun rePassword(email: String): ApiResult<ForgetPasswordResponse>
}