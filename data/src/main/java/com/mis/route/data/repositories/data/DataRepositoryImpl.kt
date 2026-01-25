package com.mis.route.data.repositories.data

import com.mis.route.domain.models.category.Category
import com.mis.route.domain.models.product.Product
import com.mis.route.domain.models.subcategory.SubCategory
import com.mis.route.domain.repositories.data.DataRepositoryContract
import com.mis.route.domain.repositories.source.OnlineDataSourceContract
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val onlineDataSource: OnlineDataSourceContract
) : DataRepositoryContract {
    override suspend fun getCategories(): List<Category?>? {
        return onlineDataSource.getCategories()
    }

    override suspend fun getSubCategory(subCategoryId: String): SubCategory? {
        return onlineDataSource.getSubCategory(subCategoryId)
    }

    override suspend fun getProducts(subCategoryId: String): List<Product?>? {
        return onlineDataSource.getProducts(subCategoryId)
    }
}