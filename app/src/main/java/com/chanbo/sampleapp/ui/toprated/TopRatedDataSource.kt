package com.chanbo.sampleapp.ui.toprated

import androidx.paging.PageKeyedDataSource
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.data.ResultsItem
import com.chanbo.sampleapp.utils.EspressoIdlingResource
import com.chanbo.sampleapp.utils.Subscriber
import timber.log.Timber

class TopRatedDataSource(
    private val repository: Repository
) : PageKeyedDataSource<Int, ResultsItem>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ResultsItem>) {
        repository.getTopRatedMovies()
            .doOnNext {
                callback.onResult(it.results!!, null, 2)
            }.doOnError {
                Timber.e("${javaClass.name} $it")
            }.subscribe(Subscriber.create())
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {
        repository.getTopRatedMovies(page = params.key)
            .doOnNext {
                callback.onResult(it.results!!, params.key + 1)
            }.doOnError {
                Timber.e("${javaClass.name} $it")
            }.subscribe(Subscriber.create())
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ResultsItem>) {
    }
}