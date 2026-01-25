package com.mis.route.e_commerce.data.models.commman

data class PaginationMetadata(
	val currentPage: Int? = null,
	val numberOfPages: Int? = null,
	val limit: Int? = null,
	val nextPage: Int? = null
)