package com.mis.route.e_commerce.data.repositories.home_repository.home_RemoteDataSource.data_Source

import com.mis.route.domain.models.category.CategoriesResponse
import com.mis.route.domain.models.product.ProductsResponse
import com.mis.route.e_commerce.data.api.services.WebServices
import com.mis.route.e_commerce.data.utils.safeApiCall
import com.mis.route.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class HomeRemoteDataSourceImpl
@Inject constructor(private val webServices: WebServices) : HomeRemoteDataSource {
    override suspend fun getCategories(): ApiResult<CategoriesResponse> {
        return safeApiCall {
            webServices.getCategories()
        }
    }

    override suspend fun getProduct(): ApiResult<ProductsResponse> {
        return safeApiCall {
            webServices.getProduct()
        }
    }

    override suspend fun getSubCategory(categoryId: String): ApiResult<CategoriesResponse> {
        return safeApiCall {
            webServices.getSubCategories(categoryId)
        }
    }
}

