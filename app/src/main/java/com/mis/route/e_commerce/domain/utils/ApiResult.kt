package com.mis.route.e_commerce.domain.utils

sealed class ApiResult<out T> {

    data class SuccessApiResult<T>(val data: T) : ApiResult<T>()

    data class ErrorApiResult(val error: AppErrors) : ApiResult<Nothing>()
}
