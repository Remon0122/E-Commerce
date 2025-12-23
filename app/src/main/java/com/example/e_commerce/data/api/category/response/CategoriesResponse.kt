package com.example.e_commerce.data.api.category.response

import com.example.e_commerce.data.api.category.model.CategoryDto

data class CategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<CategoryDto?>? = null,
)