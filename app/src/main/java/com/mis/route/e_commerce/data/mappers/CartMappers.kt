package com.mis.route.e_commerce.data.mappers

import com.mis.route.e_commerce.data.models.Cart.CartItem
import com.mis.route.e_commerce.data.models.Cart.CartResponse
import com.mis.route.e_commerce.domain.model.Cart.Cart
import javax.inject.Inject


class CartMappers @Inject constructor(
    private val productMapper: ProductMappers
) {

    fun fromCartResponse(response: CartResponse): Cart {

        val items = response.data?.products.orEmpty().mapNotNull { entry ->
            val productDM = entry?.product ?: return@mapNotNull null
            val product = productMapper.fromDataModel(productDM)

            CartItem(
                product = product,
                count = entry.count ?: 0,
                totalPrice = entry.price ?: 0.0
            )
        }

        return Cart(
            items = items,
            totalPrice = response.data?.totalCartPrice ?: 0.0,
            itemCount = response.numOfCartItems ?: items.size
        )
    }
}

