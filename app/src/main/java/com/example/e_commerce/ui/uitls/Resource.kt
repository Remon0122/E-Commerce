package com.example.e_commerce.ui.uitls



sealed class Resource<out T> {
    class IdleState<out T> : Resource<T>()
    class LoadingState<out T> : Resource<T>()
    data class SuccessState<out T>(val data: T? = null) : Resource<T>()
    data class ErrorState<out T>(val error: String) : Resource<T>()
}

