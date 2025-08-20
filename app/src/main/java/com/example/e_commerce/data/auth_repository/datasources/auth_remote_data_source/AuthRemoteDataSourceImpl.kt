package com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source

import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.request.RegisterRequest
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.data.api.web_services.WebServices
import com.example.e_commerce.data.utils.handleError

import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val services: WebServices) :
    AuthRemoteDataSource {
    override suspend fun login(email: String, password: String): ApiResult<TokenResponse> {
        return try {
            val tokenResponse = services.login(email, password)
            ApiResult.SuccessApiResult(tokenResponse)
        } catch (throwable: Throwable) {
            handleError(throwable)
        }

    }

    override suspend fun register(registerRequest: RegisterRequest): ApiResult<TokenResponse> {
        return try {
            val tokenResponse = services.register(registerRequest)
            ApiResult.SuccessApiResult(tokenResponse)
        } catch (throwable: Throwable) {
            handleError(throwable)
        }
    }

}