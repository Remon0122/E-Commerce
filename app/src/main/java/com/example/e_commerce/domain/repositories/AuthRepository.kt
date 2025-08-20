package com.example.e_commerce.domain.repositories

import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.request.RegisterRequest

interface AuthRepository {
    suspend fun login(email: String, password: String): ApiResult<Unit>
    suspend fun register(registerRequest: RegisterRequest): ApiResult<Unit>
}