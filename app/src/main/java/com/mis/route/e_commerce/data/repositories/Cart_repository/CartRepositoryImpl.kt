package com.mis.route.e_commerce.data.repositories.Cart_repository

import com.mis.route.e_commerce.data.mappers.CartMappers
import com.mis.route.e_commerce.data.repositories.Cart_repository.Cart_RemoteDataSource.data_Source.CartRemoteDataSource
import com.mis.route.e_commerce.domain.di.ConnectivityChecker
import com.mis.route.e_commerce.domain.model.Cart.Cart
import com.mis.route.e_commerce.domain.repositories.CartRepository
import com.mis.route.e_commerce.domain.utils.ApiResult
import com.mis.route.e_commerce.domain.utils.AppErrors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    val cartRemoteDataSource: CartRemoteDataSource,
    val connectivityChecker: ConnectivityChecker,
    val cartMappers: CartMappers
) : CartRepository {
    override suspend fun getCart(): Flow<ApiResult<Cart>> {
        return flow {
            if (connectivityChecker.isOnline()) {
                when (val result = cartRemoteDataSource.getCart()) {
                    is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(result.error)
                    is ApiResult.SuccessApiResult -> {
                        cartMappers.fromCartResponse(result.data)
                    }
                }
            } else {
                ApiResult.ErrorApiResult(AppErrors.NetworkError())
            }
        }
    }

    override suspend fun addCart(productId: String): Flow<ApiResult<Cart>> {
        return flow {
            if (connectivityChecker.isOnline()) {
                when (val result = cartRemoteDataSource.getCart()) {
                    is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(result.error)
                    is ApiResult.SuccessApiResult -> {
                        cartMappers.fromCartResponse(result.data)
                    }
                }
            } else {
                ApiResult.ErrorApiResult(AppErrors.NetworkError())
            }
        }
    }

    override suspend fun removeCart(productId: String): Flow<ApiResult<Cart>> {
        return flow {
            if (connectivityChecker.isOnline()) {
                when (val result = cartRemoteDataSource.getCart()) {
                    is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(result.error)
                    is ApiResult.SuccessApiResult -> {
                        cartMappers.fromCartResponse(result.data)
                    }
                }
            } else {
                ApiResult.ErrorApiResult(AppErrors.NetworkError())
            }
        }
    }

    override suspend fun UpdateQuantityCart(
        productId: String, quantity: Int
    ): Flow<ApiResult<Cart>> {
        return flow {
            if (connectivityChecker.isOnline()) {
                when (val result = cartRemoteDataSource.getCart()) {
                    is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(result.error)
                    is ApiResult.SuccessApiResult -> {
                        cartMappers.fromCartResponse(result.data)
                    }
                }
            } else {
                ApiResult.ErrorApiResult(AppErrors.NetworkError())
            }
        }
    }

}