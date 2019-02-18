package com.chanbo.sampleapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.chanbo.sampleapp.R
import com.chanbo.sampleapp.data.detail.PostersItem
import com.chanbo.sampleapp.databinding.LayoutPhotoItemBinding

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    private val _photos = ArrayList<PostersItem>()

    fun addPhotos(photos: MutableList<PostersItem>?) {
        if (photos != null) {
            with(_photos) {
                clear()
                addAll(photos)
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_photo_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = _photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class PhotoViewHolder(
        private val binding: LayoutPhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.poster = _photos[position]
        }
    }
}