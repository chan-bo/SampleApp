package com.chanbo.sampleapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.detail.CastItem
import com.chanbo.sampleapp.databinding.LayoutCastItemBinding

class CastAdapter : RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    private val _casts = ArrayList<CastItem>()

    fun addCasts(casts: MutableList<CastItem>?) {
        if (casts != null) {
            with(_casts) {
                clear()
                addAll(casts)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder =
        CastViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_cast_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = _casts.size

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class CastViewHolder(
        private val binding: LayoutCastItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.cast = _casts[position]
        }
    }
}