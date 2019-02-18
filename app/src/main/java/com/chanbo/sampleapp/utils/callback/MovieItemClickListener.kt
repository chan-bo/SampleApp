package com.chanbo.sampleapp.utils.callback

import com.chanbo.sampleapp.data.ResultsItem

interface MovieItemClickListener {

    fun onClick(position: Int, movie: ResultsItem)
}