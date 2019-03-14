package com.chanbo.sampleapp.ui.toprated

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.data.ResultsItem
import kotlinx.coroutines.CoroutineScope

class TopRatedDataSourceFactory(
    private val repository: Repository,
    private val uiScope: CoroutineScope
) : DataSource.Factory<Int, ResultsItem>() {

    private val liveData = MutableLiveData<TopRatedDataSource>()

    override fun create(): DataSource<Int, ResultsItem> {
        val source = TopRatedDataSource(repository, uiScope)
        liveData.postValue(source)
        return source
    }

}