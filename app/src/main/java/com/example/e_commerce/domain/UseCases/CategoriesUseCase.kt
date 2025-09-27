package com.example.e_commerce.domain.UseCases

import com.example.e_commerce.domain.models.categories.Category
import com.example.e_commerce.domain.repositories.Category.CategoriesRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class CategoriesUseCase @Inject constructor(val repository: CategoriesRepository ) {
    suspend operator fun invoke(): ApiResult<List<Category>>{
        return repository.getCategories()
    }
}