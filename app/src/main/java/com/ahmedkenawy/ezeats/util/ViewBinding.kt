package com.ahmedkenawy.ezeats.util

import androidx.databinding.BindingAdapter
import coil.load
import com.github.abdularis.civ.CircleImageView

object ViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(imageView: CircleImageView, imagePath: String?) {
        imageView.load(imagePath)
    }
}