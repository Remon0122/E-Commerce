package com.example.e_commerce.domain.repositories.Category

import com.example.e_commerce.data.api.web_services.ApiServices
import com.example.e_commerce.data.mappers.toDomain
import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class SubCategoryRepository @Inject constructor(
    private val apiService: ApiServices
) {
    suspend fun getSubCategories(categoryId: String): ApiResult<List<SubCategoryDomain>> {
        return try {
            val response = apiService.getSubCategoriesByCategory(categoryId)
            val domainList = response.data
                ?.mapNotNull { it?.toDomain() }
                ?: emptyList()
            ApiResult.SuccessApiResult(domainList)
        } catch (e: Exception) {
            ApiResult.ErrorApiResult(e.message ?: "Unexpected Error")
        }
    }
}