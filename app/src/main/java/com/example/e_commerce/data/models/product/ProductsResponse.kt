package com.example.e_commerce.data.models.product

data class ProductsResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<Product?>? = null
)