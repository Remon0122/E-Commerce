package com.example.e_commerce.domain.models.categories

import com.example.e_commerce.data.api.model.subCategories.SubCategory

data class Category(
    val id: String?,
    val name: String,
    val slug: String,
    val image: String,
    val createdAt: String,
    val updatedAt: String,
    val subCategories: List<SubCategory> = emptyList(),
    val isExpanded: Boolean = false
)