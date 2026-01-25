package com.mis.route.e_commerce.domain.usecases

import com.mis.route.e_commerce.domain.model.Cart.Cart
import com.mis.route.e_commerce.domain.repositories.CartRepository
import com.mis.route.e_commerce.domain.utils.ApiResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartUseCase @Inject constructor(val cartRepository: CartRepository) {
    suspend fun invoke() : Flow<ApiResult<Cart>> = cartRepository.getCart()
}