package com.example.e_commerce.domain.models.Categories

data class CategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<Category?>? = null,
)

