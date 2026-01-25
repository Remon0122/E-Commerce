package com.mis.route.domain.models.product

import com.google.gson.annotations.SerializedName
import com.mis.route.domain.models.category.CategoryDM



data class ProductDM(

    @SerializedName("sold")
    val sold: Double? = null,

    @SerializedName("images")
    val images: List<String?>? = null,

    @SerializedName("quantity")
    val quantity: Int? = null,

    @SerializedName("availableColors")
    val availableColors: List<String?>? = null,

    @SerializedName("imageCover")
    val imageCover: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("ratingsQuantity")
    val ratingsQuantity: Int? = null,

    @SerializedName("ratingsAverage")
    val ratingsAverage: Double? = null,

    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("price")
    val price: Int? = null,

    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("subcategory")
    val subcategory: List<CategoryDM?>? = null,

    @SerializedName("category")
    val category: CategoryDM? = null,

    @SerializedName("brand")
    val brand: CategoryDM? = null,

    @SerializedName("slug")
    val slug: String? = null,

    @SerializedName("updatedAt")
    val updatedAt: String? = null,

    @SerializedName("priceAfterDiscount")
    val priceAfterDiscount: Double? = null
)

