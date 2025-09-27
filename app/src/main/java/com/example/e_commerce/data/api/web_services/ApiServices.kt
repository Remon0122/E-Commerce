package com.example.e_commerce.data.api.web_services

import SubCategoriesResponse
import com.example.e_commerce.data.api.model.repassword.ForgetPasswordResponse
import com.example.e_commerce.domain.register.RegisterRequest
import com.example.e_commerce.data.api.model.response.TokenResponse
import com.example.e_commerce.data.api.model.categories.CategoriesResponse
import com.example.e_commerce.data.api.model.repassword.ForgetPasswordRequest
import com.example.e_commerce.data.api.model.subCategories.SingleSubCategoryResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @FormUrlEncoded
    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): TokenResponse

    @POST("/api/v1/auth/signup")
    suspend fun register(
        @Body registerRequest: RegisterRequest,
    ): TokenResponse

    @GET("/api/v1/categories")
    suspend fun getCategories(): CategoriesResponse

    @POST("/api/v1/auth/forgetPassword")
    suspend fun forgetPassword(
        @Body request: ForgetPasswordRequest
    ): ForgetPasswordResponse

    // ✅ جميع SubCategories (List)
    @GET("/api/v1/subcategories")
    suspend fun getSubCategories(): SubCategoriesResponse

    // ✅ SubCategories حسب CategoryId (List)
    @GET("/api/v1/subcategories")
    suspend fun getSubCategoriesByCategory(
        @Query("category") categoryId: String
    ): SubCategoriesResponse

    // ✅ SubCategory واحدة بالـ Id
    @GET("/api/v1/subcategories/{subCategoryId}")
    suspend fun getSubCategoryById(
        @Path("subCategoryId") subCategoryId: String
    ): SingleSubCategoryResponse
}
