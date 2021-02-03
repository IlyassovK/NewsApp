package com.androiddevs.mvvmnewsapp.utils

// class witch will be around of Response
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message:String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(): Resource<T>()
}