package com.example.e_commerce.domain.UseCases

import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.domain.repositories.Auth.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun execute(email: String, password: String): ApiResult<TokenResponse> {
        return repository.login(email, password)
    }
}



// view -> viewModel ->  UseCase -> Repository -> DataSource