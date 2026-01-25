package com.mis.route.e_commerce.domain.usecases

import com.mis.route.e_commerce.domain.model.product.Product
import com.mis.route.e_commerce.domain.repositories.HomeRepository
import com.mis.route.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val homeRepository: HomeRepository
) {
    suspend fun execute(): ApiResult<List<Product>> = homeRepository.getProduct()
}