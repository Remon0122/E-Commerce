package com.mis.route.e_commerce.data.repositories.Cart_repository.Cart_RemoteDataSource.data_Source

import com.mis.route.e_commerce.data.models.Cart.CartResponse
import com.mis.route.e_commerce.domain.utils.ApiResult

interface CartRemoteDataSource{
    suspend fun getCart(): ApiResult<CartResponse>
    suspend fun addCart(productId : String): ApiResult<CartResponse>
    suspend fun removeCart(productId : String): ApiResult<CartResponse>
    suspend fun UpdateQuantityCart(productId : String , quantity : Int): ApiResult<CartResponse>
}
