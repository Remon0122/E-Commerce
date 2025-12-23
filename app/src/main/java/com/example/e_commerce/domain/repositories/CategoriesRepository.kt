package com.example.e_commerce.domain.repositories

import com.example.e_commerce.data.api.web_services.CategoryApi
import com.example.e_commerce.domain.mapper.toDomain
import com.example.e_commerce.domain.model.category.Category
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val api: CategoryApi
){
    suspend fun getCategories(): List<Category> {
        return api.getCategories()
            .data
            ?.mapNotNull { it?.toDomain() }
            ?: emptyList()
    }
}