package com.chanbo.sampleapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.chanbo.sampleapp.di.GlideApp
import de.hdodenhof.circleimageview.CircleImageView

object BindingUtils {

    @BindingAdapter("poster_url")
    @JvmStatic
    fun setPostImage(imageView: ImageView, url: String?) {
        if (url == null) {
            return
        }
        GlideApp.with(imageView.context)
            .load("$IMAGE_URL_POSTER_SIZE$url")
            .apply(RequestOptions().transform(RoundedCorners(10)))
            .into(imageView)
    }

    @BindingAdapter("profile_url")
    @JvmStatic
    fun setProfilePicture(profilePicture: CircleImageView, url: String) {
        GlideApp.with(profilePicture.context)
            .load("$PROFILE_PICTURE_URL$url")
            .into(profilePicture)
    }

    @BindingAdapter("backdrop_url")
    @JvmStatic
    fun setBackdrop(imageView: ImageView, url: String?) {
        if (url != null) {
            GlideApp.with(imageView.context)
                .load("$IMAGE_URL_BACKDROP_SIZE$url")
                .into(imageView)
        }
    }
}