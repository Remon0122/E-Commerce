package com.example.e_commerce.domain.utils

sealed class AppErrors(val errorMessage: String) {
    class NetworkError(errorMessage: String = Constants.NETWORK_ERROR_MESSAGE) :
        AppErrors(errorMessage)

    class LoginRequired(errorMessage: String) : AppErrors(errorMessage)
    class IgnoredErrors(errorMessage: String) : AppErrors(errorMessage)
    class ServerError(errorMessage: String) : AppErrors(errorMessage)
}