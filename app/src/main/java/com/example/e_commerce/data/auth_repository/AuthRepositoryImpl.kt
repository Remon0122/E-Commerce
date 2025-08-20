package com.mis.route.e_commerce.data.repositories.auth_repository

import com.example.e_commerce.domain.di.ConnectivityChecker
import com.example.e_commerce.domain.repositories.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors
import com.example.e_commerce.domain.request.RegisterRequest
import com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source.AuthRemoteDataSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val connectivityChecker: ConnectivityChecker,
) : AuthRepository {
    override suspend fun login(email: String, password: String): ApiResult<Unit> {
        return if (connectivityChecker.isOnline()) {
            when (val result = remoteDataSource.login(email, password)) {
                is ApiResult.ErrorApiResult -> {
                    ApiResult.ErrorApiResult(result.error)
                }

                is ApiResult.SuccessApiResult -> {
                    ApiResult.SuccessApiResult()
                }
            }
        } else {
            ApiResult.ErrorApiResult(AppErrors.NetworkError())
        }

    }

    override suspend fun register(registerRequest: RegisterRequest): ApiResult<Unit> {
        return if (connectivityChecker.isOnline()) {
            when (val result = remoteDataSource.register(registerRequest)) {
                is ApiResult.ErrorApiResult -> {
                    ApiResult.ErrorApiResult(result.error)
                }

                is ApiResult.SuccessApiResult -> {
                    ApiResult.SuccessApiResult()
                }
            }
        } else {
            ApiResult.ErrorApiResult(AppErrors.NetworkError())
        }
    }
}