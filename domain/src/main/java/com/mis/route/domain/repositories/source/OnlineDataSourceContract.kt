package com.mis.route.domain.repositories.source

import com.mis.route.domain.models.category.Category
import com.mis.route.domain.models.product.Product
import com.mis.route.domain.models.subcategory.SubCategory

interface OnlineDataSourceContract {
    suspend fun getCategories(): List<Category?>?
    suspend fun getSubCategory(subCategoryId: String): SubCategory?
    suspend fun getProducts(subCategoryId: String): List<Product?>?
}