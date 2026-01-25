package com.mis.route.data.repositories.source

import com.mis.route.data.api.WebServices
import com.mis.route.domain.models.category.Category
import com.mis.route.domain.models.product.Product
import com.mis.route.domain.models.subcategory.SubCategory
import com.mis.route.domain.repositories.source.OnlineDataSourceContract
import javax.inject.Inject

class OnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : OnlineDataSourceContract {
    override suspend fun getCategories(): List<Category?>? {
        val response = webServices.getCategories()
        return response.data
    }

    override suspend fun getSubCategory(subCategoryId: String): SubCategory? {
        val response = webServices.getSubCategory(subCategoryId)
        return response.data?.get(0)
    }

    override suspend fun getProducts(subCategoryId: String): List<Product?>? {
        val response = webServices.getProducts(subCategoryId)
        return response.data
    }
}