package com.example.e_commerce.domain.utils

sealed class ApiResult<T>(
    val data: T? = null,
    val error: String? = null
) {
    class SuccessApiResult<T>(data: T) : ApiResult<T>(data)
    class ErrorApiResult<T>(error: String) : ApiResult<T>(null, error)
}
