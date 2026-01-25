package com.mis.route.e_commerce.domain.repositories


import com.mis.route.e_commerce.domain.model.Cart.Cart
import com.mis.route.e_commerce.domain.utils.ApiResult
import kotlinx.coroutines.flow.Flow

interface CartRepository  {
    suspend fun getCart (): Flow<ApiResult<Cart>>
    suspend fun addCart(productId : String) : Flow<ApiResult<Cart>>
    suspend fun removeCart(productId: String) : Flow<ApiResult<Cart>>
    suspend fun UpdateQuantityCart(productId : String , quantity : Int): Flow<ApiResult<Cart>>
}