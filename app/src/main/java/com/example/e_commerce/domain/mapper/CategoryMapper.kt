package com.example.e_commerce.domain.mapper

import com.example.e_commerce.data.api.category.model.CategoryDto
import com.example.e_commerce.domain.model.category.Category

fun CategoryDto.toDomain(): Category {
    return Category(
        id = id.orEmpty(),
        name = name.orEmpty(),
        image = image.orEmpty()
    )
}
