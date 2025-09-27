package com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source

import com.example.e_commerce.data.api.model.repassword.ForgetPasswordResponse
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.register.RegisterRequest
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.data.api.model.repassword.ForgetPasswordRequest
import com.example.e_commerce.data.api.web_services.ApiServices
import com.example.e_commerce.data.utils.handleError

import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(private val services: ApiServices) :
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

    override suspend fun rePassword(email: String): ApiResult<ForgetPasswordResponse> {
        return try {
            val request = ForgetPasswordRequest(email)
            val tokenResponse = services.forgetPassword(request)
            ApiResult.SuccessApiResult(tokenResponse)
        } catch (throwable: Throwable){
            handleError(throwable)
        }
    }

}