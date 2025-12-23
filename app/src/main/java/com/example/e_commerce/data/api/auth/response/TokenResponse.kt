package com.example.e_commerce.data.api.auth.response

import com.example.e_commerce.data.api.auth.model.User
import com.google.gson.annotations.SerializedName

data class TokenResponse(

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("token")
    val token: String? = null
)