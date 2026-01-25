package com.mis.route.e_commerce.domain.model.Cart

import com.mis.route.e_commerce.data.models.Cart.CartItem

data class Cart(
    val items: List<CartItem>,
    val totalPrice: Double,
    val itemCount: Int
)
