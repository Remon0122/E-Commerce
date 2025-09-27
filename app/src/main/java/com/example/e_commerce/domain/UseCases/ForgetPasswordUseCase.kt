package com.example.e_commerce.domain.UseCases

import com.example.e_commerce.data.api.model.repassword.ForgetPasswordResponse
import com.example.e_commerce.domain.repositories.Auth.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class ForgetPasswordUseCase @Inject constructor(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String): ApiResult<ForgetPasswordResponse> {
        return authRepository.rePassword(email)
    }
}