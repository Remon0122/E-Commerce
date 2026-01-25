package com.mis.route.domain.usecases

import com.mis.route.domain.models.category.Category
import com.mis.route.domain.repositories.data.DataRepositoryContract
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val dataRepository: DataRepositoryContract
) {
    suspend fun invoke(): List<Category?>? {
        return dataRepository.getCategories()
    }
}