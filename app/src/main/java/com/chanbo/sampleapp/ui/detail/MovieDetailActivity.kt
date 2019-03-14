package com.chanbo.sampleapp.ui.detail

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chanbo.sampleapp.BR
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.detail.MovieDetailResponse
import com.chanbo.sampleapp.databinding.ActivityMovieDetailBinding
import com.chanbo.sampleapp.ui.base.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailActivity : BaseActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {

    private lateinit var _castAdapter: CastAdapter
    private lateinit var _photoAdapter: PhotoAdapter

    override fun getLayoutId(): Int = R.layout.activity_movie_detail

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MovieDetailViewModel by viewModel()

    override fun onInitView(savedInstanceState: Bundle?) {

//        appBar.clipToStatusBar()
        setUpRecyclerView()

        val movieDetail = Gson().fromJson(intent.getStringExtra("detail"), MovieDetailResponse::class.java)
        mBinding.detail = movieDetail

        _castAdapter.addCasts(movieDetail.credits?.cast?.toMutableList())
        _photoAdapter.addPhotos(movieDetail.images?.posters?.toMutableList())
    }

    override fun subscriptLiveData() {
    }

    private fun setUpRecyclerView() {
        _castAdapter = CastAdapter()
        _photoAdapter = PhotoAdapter()

        castRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        castRecyclerView.adapter = _castAdapter
        castRecyclerView.isNestedScrollingEnabled = false

        photoRecyclerView.layoutManager = GridLayoutManager(this, 2, RecyclerView.VERTICAL, false)
        photoRecyclerView.adapter = _photoAdapter
        photoRecyclerView.isNestedScrollingEnabled = false
    }
}
