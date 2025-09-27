package com.example.e_commerce.data.mappers

import com.example.e_commerce.data.api.model.subCategories.SubCategory
import com.example.e_commerce.domain.models.SubCategory.SubCategoryDomain

fun SubCategory.toDomain(): SubCategoryDomain {
    return SubCategoryDomain(
        id = this.id ?: "",
        name = this.name ?: "",
        slug = this.slug ?: "",
        category = this.category ?: "",
        createdAt = this.createdAt ?: "",
        updatedAt = this.updatedAt ?: ""
    )
}

fun List<SubCategory?>.toDomainList(): List<SubCategoryDomain> {
    return this.mapNotNull { it?.toDomain() }
}
