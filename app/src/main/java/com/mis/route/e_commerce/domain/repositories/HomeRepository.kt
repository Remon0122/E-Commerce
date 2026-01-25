package com.mis.route.e_commerce.domain.repositories

import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.domain.model.product.Product
import com.mis.route.e_commerce.domain.utils.ApiResult

interface HomeRepository {
    suspend fun getCategory(): ApiResult<List<Category>>
    suspend fun getProduct(): ApiResult<List<Product>>
    suspend fun getSubCategory (categoryId: String): ApiResult<List<Category>>
}