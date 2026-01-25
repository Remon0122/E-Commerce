package com.mis.route.domain.models.product

data class Metadata(
	val currentPage: Int? = null,
	val numberOfPages: Int? = null,
	val limit: Int? = null,
	val nextPage: Int? = null
)