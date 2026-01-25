package com.mis.route.e_commerce.domain.model.product

import android.os.Parcelable
import com.mis.route.e_commerce.domain.model.category.Category
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val description: String,
    val imageCover: String,
    val images: List<String>,
    val price: Double,
    val priceAfterDiscount: Double?,
    val ratingsAverage: Double,
    val ratingsQuantity: Int,
    val quantity: Int,
    val availableColors: List<String>,
    val category: Category
): Parcelable
