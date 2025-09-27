package com.example.e_commerce.data.api.model.categories

data class CategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<CategoryDto?>? = null,
)

