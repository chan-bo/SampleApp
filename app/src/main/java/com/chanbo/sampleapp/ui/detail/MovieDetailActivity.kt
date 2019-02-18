package com.chanbo.sampleapp.ui.detail

import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanbo.sampleapp.BR
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import com.chanbo.sampleapp.databinding.ActivityMovieDetailBinding
import com.chanbo.sampleapp.di.GlideApp
import com.chanbo.sampleapp.ui.base.BaseActivity
import com.chanbo.sampleapp.utils.IMAGE_URL_BACKDROP_SIZE
import com.chanbo.sampleapp.utils.clipToStatusBar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {

    private lateinit var _castAdapter: CastAdapter
    private lateinit var _photoAdapter: PhotoAdapter

    override fun getLayoutId(): Int = R.layout.activity_movie_detail

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MovieDetailViewModel
        get() = injectViewModel(MovieDetailViewModel::class.java)

    override fun onInitView(savedInstanceState: Bundle?) {

//        appBar.clipToStatusBar()
        setUpRecyclerView()

        val movieDetail = Gson().fromJson(intent.getStringExtra("detail"), MovieDetailResponse::class.java)
        mBinding.detail = movieDetail

        _castAdapter.addCasts(movieDetail.credits?.cast?.toMutableList())
        _photoAdapter.addPhotos(movieDetail.images?.posters?.toMutableList())

       /* GlideApp.with(imgBackdrop.context)
            .load("$IMAGE_URL_BACKDROP_SIZE${movieDetail.backdropPath}")
            .into(imgBackdrop)*/
    }

    override fun subscriptLiveData() {

    }

    private fun setUpRecyclerView() {
        _castAdapter = CastAdapter()
        _photoAdapter = PhotoAdapter()

        castRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        castRecyclerView.adapter = _castAdapter

        photoRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL , false)
        photoRecyclerView.adapter = _photoAdapter
    }
}
