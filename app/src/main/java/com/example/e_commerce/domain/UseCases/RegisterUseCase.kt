package com.example.e_commerce.domain.UseCases

import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.domain.register.RegisterRequest
import com.example.e_commerce.domain.repositories.Auth.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        phone: String,
        email: String,
        password: String
    ): ApiResult<TokenResponse> {
        return repository.register(RegisterRequest(
            name = name,
            phone = phone,
            email = email,
            password = password,
            rePassword = password
        ))
    }
}

