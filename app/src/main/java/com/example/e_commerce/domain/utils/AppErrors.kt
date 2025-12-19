package com.example.e_commerce.domain.utils

sealed class AppErrors(val errorMessage: String) {
    class NetworkError(errorMessage: String = Constants.NETWORK_ERROR_MESSAGE) : AppErrors(errorMessage)
    class LoginRequired(errorMessage: String = "Login is required") : AppErrors(errorMessage)
    class IgnoredErrors(errorMessage: String = "Ignored error") : AppErrors(errorMessage)
    class ServerError(errorMessage: String = "Server error occurred") : AppErrors(errorMessage)
    class ValidationError(errorMessage: String) : AppErrors(errorMessage)
}
