package com.mis.route.e_commerce.data.models.Cart

import com.google.gson.annotations.SerializedName

data class CartDM(

	@field:SerializedName("cartOwner")
	val cartOwner: String? = null,

	@field:SerializedName("totalCartPrice")
	val totalCartPrice: Double? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("products")
	val products: List<CartEntry?>? = null
)