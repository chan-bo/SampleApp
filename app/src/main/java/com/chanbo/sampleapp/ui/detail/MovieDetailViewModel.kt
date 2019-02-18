package com.chanbo.sampleapp.ui.detail

import com.chanbo.sampleapp.api.Repository
import com.chanbo.sampleapp.ui.base.BaseViewModel
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val repository: Repository
) : BaseViewModel() {

}