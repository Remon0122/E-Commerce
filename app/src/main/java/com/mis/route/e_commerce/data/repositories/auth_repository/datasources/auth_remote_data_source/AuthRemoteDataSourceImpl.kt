package com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source

import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.data.api.services.WebServices
import com.mis.route.e_commerce.data.utils.safeApiCall
import com.mis.route.e_commerce.domain.model.request.RegisterRequest
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.domain.utils.AppErrors
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val services: WebServices
) : AuthRemoteDataSource {

    override suspend fun login(
        email: String,
        password: String
    ): ApiResult<TokenResponse> = safeApiCall {
        services.login(password,email)
    }

    override suspend fun register(
        registerRequest: RegisterRequest
    ): ApiResult<TokenResponse> = safeApiCall {
        services.register(registerRequest)
    }
}
