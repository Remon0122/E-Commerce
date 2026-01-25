package com.mis.route.e_commerce.data.repositories.home_repository.home_RemoteDataSource.data_Source

import com.mis.route.domain.models.category.CategoriesResponse
import com.mis.route.domain.models.product.ProductsResponse
import com.mis.route.e_commerce.domain.utils.ApiResult

interface HomeRemoteDataSource {

    suspend fun getCategories() : ApiResult<CategoriesResponse>
    suspend fun getProduct() : ApiResult<ProductsResponse>

    suspend fun getSubCategory(categoryId : String): ApiResult<CategoriesResponse>
}