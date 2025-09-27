package com.example.e_commerce.data.api.model.product

import com.example.e_commerce.data.api.model.categories.CategoryDto
import com.example.e_commerce.data.api.model.brand.Brand
import com.example.e_commerce.data.api.model.subCategories.SubCategory



data class Product(
    val sold: Int? = null,
    val images: List<String?>? = null,
    val quantity: Int? = null,
    val availableColors: List<Any?>? = null,
    val imageCover: String? = null,
    val description: String? = null,
    val title: String? = null,
    val ratingsQuantity: Int? = null,
    val ratingsAverage: Any? = null,
    val createdAt: String? = null,
    val price: Int? = null,
    val id: String? = null,
    val subcategory: List<SubCategory?>? = null,
    val category: CategoryDto? = null,
    val brand: Brand? = null,
    val slug: String? = null,
    val updatedAt: String? = null,
    val priceAfterDiscount: Int? = null
)