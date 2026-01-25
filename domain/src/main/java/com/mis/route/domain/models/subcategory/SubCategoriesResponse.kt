package com.mis.route.domain.models.subcategory

data class SubCategoriesResponse(
    val results: Int? = null,
    val metadata: Metadata? = null,
    val data: List<SubCategory?>? = null,
)