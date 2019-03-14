package com.chanbo.sampleapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {

    private val _viewModelJob = Job()

    val uiScope = CoroutineScope(Dispatchers.Main + _viewModelJob)

    val isLoading = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        _viewModelJob.cancel()
    }
}