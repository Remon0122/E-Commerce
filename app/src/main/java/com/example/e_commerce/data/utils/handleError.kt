package com.example.e_commerce.data.utils

import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors

fun <T> handleError(throwable: Throwable): ApiResult.ErrorApiResult<T> {
    return when (throwable) {
        is java.net.UnknownHostException -> ApiResult.ErrorApiResult(AppErrors.NetworkError().errorMessage)
        is java.net.SocketTimeoutException -> ApiResult.ErrorApiResult(AppErrors.ServerError("Request timed out").errorMessage)
        else -> ApiResult.ErrorApiResult(AppErrors.ServerError(throwable.message ?: "Unexpected error").errorMessage)
    }
}
