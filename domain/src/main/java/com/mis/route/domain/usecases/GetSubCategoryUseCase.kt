package com.mis.route.domain.usecases

import com.mis.route.domain.models.subcategory.SubCategory
import com.mis.route.domain.repositories.data.DataRepositoryContract
import javax.inject.Inject

class GetSubCategoryUseCase @Inject constructor(
    private val dataRepository: DataRepositoryContract
) {
    suspend fun invoke(subCategoryId: String): SubCategory? {
        return dataRepository.getSubCategory(subCategoryId)
    }
}