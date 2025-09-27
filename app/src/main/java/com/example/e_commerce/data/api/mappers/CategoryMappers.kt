package com.example.e_commerce.data.api.mappers

import com.example.e_commerce.data.api.model.categories.CategoryDto
import com.example.e_commerce.domain.models.categories.Category

fun CategoryDto.toDomain(): Category {
    return Category(
        id = this.id,
        name = this.name ?: "",
        slug = this.slug ?: "",
        image = this.image ?: "",
        createdAt = this.createdAt ?: "",
        updatedAt = this.updatedAt ?: ""
    )
}

fun List<CategoryDto?>?.toDomainList(): List<Category> {
    return this?.mapNotNull { it?.toDomain() } ?: emptyList()
}