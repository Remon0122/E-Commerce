package com.mis.route.e_commerce.data.repositories.Cart_repository.Cart_RemoteDataSource.data_Source

import com.mis.route.e_commerce.data.api.services.WebServices
import com.mis.route.e_commerce.data.models.Cart.CartResponse
import com.mis.route.e_commerce.data.utils.safeApiCall
import com.mis.route.e_commerce.domain.utils.ApiResult
import javax.inject.Inject

class CartRemoteDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    CartRemoteDataSource {
    override suspend fun getCart(): ApiResult<CartResponse> = safeApiCall {
        webServices.getCart()
    }


    override suspend fun addCart(productId: String): ApiResult<CartResponse> = safeApiCall {
        webServices.addToCart(productId)
    }

    override suspend fun removeCart(productId: String): ApiResult<CartResponse> = safeApiCall {
        webServices.removeFromCart(productId)
    }

    override suspend fun UpdateQuantityCart(productId: String , quantity : Int): ApiResult<CartResponse> = safeApiCall {
        webServices.UpdatedCartQuantity(productId, quantity)
    }

}