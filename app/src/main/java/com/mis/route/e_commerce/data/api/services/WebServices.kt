package com.mis.route.e_commerce.data.api.services

import com.mis.route.domain.models.category.CategoriesResponse
import com.mis.route.domain.models.product.ProductsResponse
import com.mis.route.e_commerce.domain.model.request.RegisterRequest
import com.mis.route.e_commerce.data.models.auth.TokenResponse
import com.mis.route.e_commerce.data.models.Cart.CartResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WebServices {
    @FormUrlEncoded
    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): TokenResponse

    @POST("/api/v1/auth/signup")
    suspend fun register(
        @Body registerRequest: RegisterRequest
    ): TokenResponse

    @GET("/api/v1/categories")
    suspend fun getCategories(): CategoriesResponse

    @GET("/api/v1/products")
    suspend fun getProduct(): ProductsResponse

    // data/api/ECommerceApi.kt
    @GET("/api/v1/categories/{categoryId}/subcategories")
    suspend fun getSubCategories(
        @Path("categoryId") categoryId: String
    ): CategoriesResponse

    @GET("/api/v1/cart")
    suspend fun getCart(): CartResponse

    @GET("/api/v1/cart{productId}")
    suspend fun addToCart(@Field("productId") productId: String): CartResponse

    @DELETE("/api/v1/cart{productId}")
    suspend fun removeFromCart(@Field("productId") productId: String): CartResponse

    @PUT("/api/v1/cart{productId}")
    suspend fun UpdatedCartQuantity(
        @Field("productId") productId: String, @Field("count") QuantityId: Int
    ): CartResponse
}


/// View -> ViewModel -> UseCases -> Repositories -> DataSource