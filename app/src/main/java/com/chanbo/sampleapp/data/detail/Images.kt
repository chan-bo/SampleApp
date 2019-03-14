package com.chanbo.sampleapp.data.detail

import com.google.gson.annotations.SerializedName

data class Images(

    @field:SerializedName("backdrops")
    val backdrops: List<BackdropsItem?>? = null,

    @field:SerializedName("posters")
    val posters: List<PostersItem>? = null
)