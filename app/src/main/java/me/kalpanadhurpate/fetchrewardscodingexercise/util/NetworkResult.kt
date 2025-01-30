package me.kalpanadhurpate.fetchrewardscodingexercise.util

sealed class NetworkResult<out T> {

    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String, val cause: Throwable? = null) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

}