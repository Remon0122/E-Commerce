package com.example.e_commerce.domain.repositories.Category

import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain
import com.example.e_commerce.domain.utils.ApiResult

interface ISubCategoryRepository {
    suspend fun getSubCategories(categoryId: String): ApiResult<List<SubCategoryDomain>>
}