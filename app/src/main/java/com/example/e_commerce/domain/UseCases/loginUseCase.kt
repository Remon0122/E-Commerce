package com.example.e_commerce.domain.UseCases

import com.example.e_commerce.domain.repositories.AuthRepository
import com.example.e_commerce.domain.utils.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class loginUseCase @Inject constructor(var repo : AuthRepository){

    suspend fun execute(emile : String , password : String) : ApiResult<Unit>{
        return repo.login(emile,password)
    }
}


// view -> viewModel -> Repository -> UseCase -> DataSource