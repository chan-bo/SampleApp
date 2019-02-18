package com.chanbo.sampleapp.ui.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.data.ResultsItem
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import com.chanbo.sampleapp.ui.base.BaseViewModel
import com.chanbo.sampleapp.utils.Subscriber
import timber.log.Timber
import javax.inject.Inject

class TopRatedViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

    val topRatedLiveData: LiveData<PagedList<ResultsItem>>
    val movieDetailLiveData = MutableLiveData<MovieDetailResponse>()

    init {
        val factory = TopRatedDataSourceFactory(repository)

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(10)
            .build()

        topRatedLiveData = LivePagedListBuilder<Int, ResultsItem>(factory, config)
            .build()
    }

    fun getMovieDetail(movieId: Int) {
        isLoading.postValue(true)
        repository.getMovieDetail(movieId = movieId)
            .doOnNext {
                movieDetailLiveData.postValue(it)
            }.doOnError {
                Timber.e("error $it")
            }.doOnComplete {
                isLoading.postValue(false)
            }
            .subscribe(Subscriber.create())
    }
}