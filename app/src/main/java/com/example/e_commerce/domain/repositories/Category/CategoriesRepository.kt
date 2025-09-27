package com.example.e_commerce.domain.repositories.Category

import com.example.e_commerce.domain.models.categories.Category
import com.example.e_commerce.domain.utils.ApiResult

interface CategoriesRepository {
    suspend fun getCategories(): ApiResult<List<Category>>
}