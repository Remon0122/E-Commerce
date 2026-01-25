package com.mis.route.e_commerce.domain.repositories

import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.domain.model.request.RegisterRequest
import com.mis.route.e_commerce.domain.utils.ApiResult

interface AuthRepository {
    suspend fun login(email: String, password: String): ApiResult<TokenResponse>
    suspend fun register(registerRequest: RegisterRequest): ApiResult<TokenResponse>
}