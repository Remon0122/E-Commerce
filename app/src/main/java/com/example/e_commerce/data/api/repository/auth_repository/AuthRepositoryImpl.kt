package com.mis.route.e_commerce.data.repositories.auth_repository

import com.example.e_commerce.data.RDB.DAO.AccountDao
import com.example.e_commerce.data.RDB.Entity.AccountEntity
import com.example.e_commerce.data.api.model.repassword.ForgetPasswordResponse
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.domain.di.ConnectivityChecker
import com.example.e_commerce.domain.repositories.Auth.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.register.RegisterRequest
import com.mis.route.e_commerce.data.repositories.auth_repository.datasources.auth_remote_data_source.AuthRemoteDataSource
import javax.inject.Inject



class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val connectivityChecker: ConnectivityChecker,
    private val accountDao: AccountDao
) : AuthRepository {

    override suspend fun login(email: String, password: String): ApiResult<TokenResponse> {
        return if (connectivityChecker.isOnline()) {
            val result = remoteDataSource.login(email, password)

            if (result is ApiResult.SuccessApiResult) {
                // لو رجع مع الـ login بيانات، احفظها في Room
                val account = AccountEntity(
                    name = "", // هنا محتاج API يرجعلك الاسم
                    email = email,
                    phone = "", // نفس الكلام
                    address = "",
                    password = password
                )
                accountDao.insertAccount(account)
            }

            result
        } else {
            ApiResult.ErrorApiResult("No internet connection")
        }
    }

    override suspend fun register(registerRequest: RegisterRequest): ApiResult<TokenResponse> {
        return if (connectivityChecker.isOnline()) {
            val result = remoteDataSource.register(registerRequest)

            if (result is ApiResult.SuccessApiResult) {
                // لو الـ register نجح → نخزن البيانات في Room
                val account = AccountEntity(
                    name = registerRequest.name ?: "",
                    email = registerRequest.email ?: "",
                    phone = registerRequest.phone ?: "",
                    address = "",
                    password = registerRequest.password ?: ""
                )
                accountDao.insertAccount(account)
            }

            result
        } else {
            ApiResult.ErrorApiResult("No internet connection")
        }
    }

    override suspend fun rePassword(email: String): ApiResult<ForgetPasswordResponse> {
        return if (connectivityChecker.isOnline()) {
            remoteDataSource.rePassword(email)
        } else {
            ApiResult.ErrorApiResult("No internet connection")
        }
    }
}



