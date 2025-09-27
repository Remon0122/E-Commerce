package com.example.e_commerce.domain.UseCases

import SubCategoriesResponse
import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain
import com.example.e_commerce.domain.repositories.Category.ISubCategoryRepository
import com.example.e_commerce.domain.repositories.Category.SubCategoryRepository
import com.example.e_commerce.domain.utils.ApiResult
import javax.inject.Inject


class GetSubCategoriesUseCase @Inject constructor(
    private val repository: ISubCategoryRepository
) {
    suspend operator fun invoke(categoryId: String): ApiResult<List<SubCategoryDomain>> {
        return repository.getSubCategories(categoryId)
    }
}
