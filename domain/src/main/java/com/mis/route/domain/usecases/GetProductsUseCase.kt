package com.mis.route.domain.usecases

import com.mis.route.domain.models.product.Product
import com.mis.route.domain.repositories.data.DataRepositoryContract
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val dataRepository: DataRepositoryContract
) {
    suspend fun invoke(subCategoryId: String): List<Product?>? {
        return dataRepository.getProducts(subCategoryId)
    }
}