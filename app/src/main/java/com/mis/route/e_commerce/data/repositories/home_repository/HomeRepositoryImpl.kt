package com.mis.route.e_commerce.data.repositories.home_repository

import com.mis.route.e_commerce.data.mappers.CategoryMappers
import com.mis.route.e_commerce.data.mappers.ProductMappers
import com.mis.route.e_commerce.data.repositories.home_repository.home_RemoteDataSource.data_Source.HomeRemoteDataSource
import com.mis.route.e_commerce.domain.di.ConnectivityChecker
import com.mis.route.e_commerce.domain.model.category.Category
import com.mis.route.e_commerce.domain.model.product.Product
import com.mis.route.e_commerce.domain.repositories.HomeRepository
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.domain.utils.ApiResult.*
import com.mis.route.e_commerce.domain.utils.AppErrors.*
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeRepositoryDataSource: HomeRemoteDataSource,
    private val connectivityChecker: ConnectivityChecker ,
    private val categoryMappers: CategoryMappers,
    private val productMapper : ProductMappers
) : HomeRepository {


    override suspend fun getCategory(): ApiResult<List<Category>> {
        if (!connectivityChecker.isOnline()) {
            return ErrorApiResult(NetworkError())
        }

        return when (val result = homeRepositoryDataSource.getCategories()) {
            is SuccessApiResult -> {
                val categories = result.data.categories
                    ?.let { categoryMappers.fromDataModels(it) }
                    ?: emptyList()

                if (categories.isEmpty()) {
                    ErrorApiResult(ServerError())
                } else {
                    SuccessApiResult(categories)
                }
            }
            is ErrorApiResult -> ErrorApiResult(result.error)
        }
    }

    override suspend fun getProduct(): ApiResult<List<Product>> {
        if (!connectivityChecker.isOnline()) {
            return ErrorApiResult(NetworkError())
        }

        return when (val result = homeRepositoryDataSource.getProduct()) {
            is SuccessApiResult -> {
                val categories = result.data.product
                    ?.let { productMapper.fromDataModels(it) }
                    ?: emptyList()

                if (categories.isEmpty()) {
                    ErrorApiResult(ServerError())
                } else {
                    SuccessApiResult(categories)
                }
            }
            is ErrorApiResult -> ErrorApiResult(result.error)
        }
    }

    override suspend fun getSubCategory(categoryId : String): ApiResult<List<Category>> {
        if (!connectivityChecker.isOnline()) {
            return ErrorApiResult(NetworkError())
        }

        return when (val result = homeRepositoryDataSource.getSubCategory(categoryId)) {
            is SuccessApiResult -> {
                val categories = result.data.categories
                    ?.let { categoryMappers.fromDataModels(it) }
                    ?: emptyList()

                if (categories.isEmpty()) {
                    ErrorApiResult(ServerError())
                } else {
                    SuccessApiResult(categories)
                }
            }
            is ErrorApiResult -> ErrorApiResult(result.error)
        }
    }

}