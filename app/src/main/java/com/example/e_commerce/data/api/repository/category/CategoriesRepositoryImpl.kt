package com.example.e_commerce.data.api.repository.category

import com.example.e_commerce.data.api.mappers.toDomainList
import com.example.e_commerce.data.api.web_services.ApiServices
import com.example.e_commerce.domain.models.categories.Category
import com.example.e_commerce.domain.repositories.Category.CategoriesRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices
) : CategoriesRepository {

    override suspend fun getCategories(): ApiResult<List<Category>> {
        return try {
            val response = apiServices.getCategories()
            val categories = response.data.toDomainList()
            ApiResult.SuccessApiResult(categories)
        } catch (e: Exception) {
            ApiResult.ErrorApiResult(e.localizedMessage ?: "Unknown error")
        }
    }
}