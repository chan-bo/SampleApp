package com.chanbo.sampleapp.api

import retrofit2.Response
import com.chanbo.sampleapp.api.callback.Result
import java.lang.Exception

open class BaseRepository {

    suspend fun <T : Any> apiCallback(call: suspend () -> Response<T>): Result<T> {
        val response = call.invoke()
        return when (response.isSuccessful) {
            true -> Result.Success(response.body()!!)
            false -> Result.Failed(Exception(response.errorBody()?.string()))
        }
    }
}