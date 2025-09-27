package com.example.e_commerce.data.api.model.product

data class ProductsResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<Product?>? = null
)