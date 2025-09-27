package com.example.e_commerce.domain.models.SubCategory


data class SubCategoryDomain(
    val id: String,
    val name: String,
    val slug: String,
    val category: String,
    val createdAt: String,
    val updatedAt: String
)