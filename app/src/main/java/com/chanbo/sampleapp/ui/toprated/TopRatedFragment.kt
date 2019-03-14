package com.chanbo.sampleapp.ui.toprated


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chanbo.sampleapp.BR

import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.ResultsItem
import com.chanbo.sampleapp.databinding.FragmentTopRatedBinding
import com.chanbo.sampleapp.ui.base.BaseFragment
import com.chanbo.sampleapp.ui.detail.MovieDetailActivity
import com.chanbo.sampleapp.utils.EspressoIdlingResource
import com.chanbo.sampleapp.utils.callback.MovieItemClickListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_top_rated.*
import org.koin.android.viewmodel.ext.android.viewModel


class TopRatedFragment : BaseFragment<FragmentTopRatedBinding, TopRatedViewModel>() {

    private lateinit var _adapter: TopRatedAdapter

    override fun getLayoutId(): Int = R.layout.fragment_top_rated

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: TopRatedViewModel by viewModel()

    override fun onInitView(view: View, savedInstanceState: Bundle?) {
        _adapter = TopRatedAdapter()
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = _adapter

        _adapter.setMovieItemClickListener(object : MovieItemClickListener {
            override fun onClick(position: Int, movie: ResultsItem) {
                EspressoIdlingResource.increment()
                viewModel.getMovieDetail(movie.id!!)
            }
        })
    }

    override fun subscriptLiveData() {
        viewModel.topRatedLiveData.observe(this, Observer {
            _adapter.submitList(it)
        })
        viewModel.movieDetailLiveData.observe(this, Observer {
            EspressoIdlingResource.decrement()
            startActivity(
                Intent(
                    this@TopRatedFragment.context, MovieDetailActivity::class.java
                ).apply { putExtra("detail", Gson().toJson(it)) }
            )
        })
        viewModel.isLoading.observe(this, Observer {
           progressBar.visibility = when(it) {
               true -> View.VISIBLE
               else -> View.INVISIBLE
           }
        })
    }

}
