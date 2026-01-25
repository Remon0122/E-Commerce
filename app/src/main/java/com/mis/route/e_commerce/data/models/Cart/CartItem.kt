package com.mis.route.e_commerce.data.models.Cart

import com.mis.route.e_commerce.domain.model.product.Product

data class CartItem(
    val product: Product,
    val count: Int,
    val totalPrice: Double
)
