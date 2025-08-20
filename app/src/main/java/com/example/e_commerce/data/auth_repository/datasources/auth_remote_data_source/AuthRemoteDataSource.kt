package com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source

import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.request.RegisterRequest
import com.example.e_commerce.data.api.model.response.TokenResponse

interface AuthRemoteDataSource {
    suspend fun login(email: String, password: String): ApiResult<TokenResponse>
    suspend fun register(registerRequest: RegisterRequest): ApiResult<TokenResponse>
}