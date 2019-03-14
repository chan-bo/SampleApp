package com.chanbo.sampleapp.api.callback

import java.lang.Exception

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failed(val exception: Exception) : Result<Nothing>()
}