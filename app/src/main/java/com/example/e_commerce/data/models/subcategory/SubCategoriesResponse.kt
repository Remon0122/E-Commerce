package com.example.e_commerce.data.models.subcategory

data class SubCategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<SubCategory?>? = null,
)