package com.mis.route.data.api

import com.mis.route.domain.models.category.CategoriesResponse
import com.mis.route.domain.models.product.ProductsResponse
import com.mis.route.domain.models.subcategory.SubCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {
    @GET("api/v1/categories")
    suspend fun getCategories(): CategoriesResponse

    @GET("api/v1/subcategories{id}")
    suspend fun getSubCategory(
        @Path("id") subCategoryId: String
    ): SubCategoriesResponse

    @GET("api/v1/products")
    suspend fun getProducts(
        @Query("subcategory") subCategoryId: String
    ): ProductsResponse
}