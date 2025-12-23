package com.example.e_commerce.data.api.web_services

import com.example.e_commerce.data.api.category.response.CategoriesResponse
import retrofit2.http.GET

interface CategoryApi {

    @GET("api/v1/categories")
    suspend fun getCategories(): CategoriesResponse
}
