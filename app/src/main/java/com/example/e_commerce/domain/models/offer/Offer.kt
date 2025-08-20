package com.example.e_commerce.domain.models.offer

data class Offer(
    val id: Int,
    val percentage: Int,
    val imageResId: Int,
    val categoryId: String,
    val targetText: String
) {
    fun getFormattedPercent(): String = "$percentage%"
}