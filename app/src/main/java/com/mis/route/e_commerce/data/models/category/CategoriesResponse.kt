package com.mis.route.domain.models.category

import com.google.gson.annotations.SerializedName
import com.mis.route.e_commerce.data.models.commman.PaginationMetadata

data class CategoriesResponse(
    val results: Int? = null,
    val metadata: PaginationMetadata? = null,
    @SerializedName("data")
    val categories: List<CategoryDM>? = null
)


