package com.example.e_commerce.data.utils

import com.example.e_commerce.domain.utils.ApiResult
import com.example.e_commerce.domain.utils.AppErrors

fun <T> handleError(throwable: Throwable): ApiResult.ErrorApiResult<T> {
    return ApiResult.ErrorApiResult(AppErrors.ServerError(throwable.message ?: ""))
}