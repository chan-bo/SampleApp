package com.chanbo.sampleapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
}