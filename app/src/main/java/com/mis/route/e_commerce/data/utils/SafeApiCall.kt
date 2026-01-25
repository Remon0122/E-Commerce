package com.mis.route.e_commerce.data.utils

import com.mis.route.e_commerce.domain.utils.ApiResult

suspend fun <T> safeApiCall(call : suspend ()-> T): ApiResult<T>{
    try {
        val t = call.invoke()
        return ApiResult.SuccessApiResult(t)
    }catch (e: Throwable){
        return handleError(e)
    }
}