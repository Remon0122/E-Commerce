package com.example.e_commerce.domain.usecases

import com.example.e_commerce.data.models.request.RegisterRequest
import com.example.e_commerce.domain.repositories.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class RegisterUseCase @Inject constructor(var repo: AuthRepository) {
    suspend fun execute(registerRequest: RegisterRequest): ApiResult<Unit> {
        return repo.register(registerRequest)
    }
}