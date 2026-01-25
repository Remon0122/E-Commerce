package com.mis.route.e_commerce.domain.usecases

import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.domain.repositories.AuthRepository
import com.mis.route.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(var repo: AuthRepository) {
    suspend fun execute(email: String, password: String): ApiResult<TokenResponse> {
        return repo.login(email, password)
    }
}