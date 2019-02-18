package com.chanbo.sampleapp.ui.toprated

import android.animation.ObjectAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.ResultsItem
import com.chanbo.sampleapp.databinding.LayoutTopRatedItemBinding
import com.chanbo.sampleapp.utils.callback.MovieItemClickListener

class TopRatedAdapter : PagedListAdapter<ResultsItem, TopRatedAdapter.TopRatedViewHolder>(
    DIFF_CALLBACK
) {

    private var _movieItemClickListener : MovieItemClickListener? = null

    fun setMovieItemClickListener(movieItemClickListener: MovieItemClickListener) {
        _movieItemClickListener = movieItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        return TopRatedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_top_rated_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(position)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class TopRatedViewHolder(
        private val binding: LayoutTopRatedItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.movie = getItem(position)
            ObjectAnimator.ofFloat(binding.root, "alpha", 0f, 1f).apply {
                duration = 1500
            }.start()
            binding.container.setOnClickListener {
                _movieItemClickListener?.onClick(adapterPosition, getItem(position)!!)
            }
        }
    }

}