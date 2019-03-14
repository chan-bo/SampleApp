package com.chanbo.sampleapp.ui.toprated

import androidx.paging.PageKeyedDataSource
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.api.callback.Result
import com.chanbo.sampleapp.data.ResultsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber

class TopRatedDataSource(
    private val repository: Repository,
    private val uiScope: CoroutineScope
) : PageKeyedDataSource<Int, ResultsItem>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ResultsItem>) {
        uiScope.launch {
            val response = repository.getTopRatedMovies()
            when (response) {
                is Result.Success -> {
                    callback.onResult(response.data.results!!, null, 2)
                }
                is Result.Failed -> {
                    Timber.d("${response.exception}")
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {
        uiScope.launch {
            val response = repository.getTopRatedMovies()
            when (response) {
                is Result.Success -> {
                    callback.onResult(response.data.results!!, params.key + 1)
                }
                is Result.Failed -> {
                    Timber.d("${response.exception}")
                }
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {
    }
}