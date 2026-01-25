package com.mis.route.domain.models.product

import com.google.gson.annotations.SerializedName
import com.mis.route.e_commerce.data.models.commman.PaginationMetadata

data class ProductsResponse(
    val results: Int? = null,
    val metadata: PaginationMetadata? = null,
    @SerializedName("data")
    val product: List<ProductDM>? = null
)