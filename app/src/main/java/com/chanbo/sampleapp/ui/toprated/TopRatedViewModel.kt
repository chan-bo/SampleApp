package com.chanbo.sampleapp.ui.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.api.callback.Result
import com.chanbo.sampleapp.data.ResultsItem
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import com.chanbo.sampleapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class TopRatedViewModel(
    private val repository: Repository
) : BaseViewModel() {

    val topRatedLiveData: LiveData<PagedList<ResultsItem>>
    val movieDetailLiveData = MutableLiveData<MovieDetailResponse>()

    init {
        val factory = TopRatedDataSourceFactory(repository, uiScope)

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
        uiScope.launch {
            val response = repository.getMovieDetail(movieId = movieId)
            isLoading.postValue(false)
            when (response) {
                is Result.Success -> {
                    movieDetailLiveData.postValue(response.data)
                }
            }
        }
    }
}