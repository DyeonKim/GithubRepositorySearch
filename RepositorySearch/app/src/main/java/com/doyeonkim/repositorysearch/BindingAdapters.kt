package com.doyeonkim.repositorysearch

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:ownerImg")
    fun setOwnerImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .circleCrop()
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("app:countFormat")
    fun setCountFormat(textView: TextView, count: Int) {
        var result: String

        if (count >= 1_000_000_000) {       // B
            result = "${(count / 1_000_000_000)}.${(count % 1_000_000_000) / 100_000_000}B"
        } else if (count >= 1_000_000) {    // M
            result = "${(count / 1_000_000)}.${(count % 1_000_000) / 100_000}M"
        } else if (count >= 1_000) {        // K
            result = "${(count / 1_000)}.${(count % 1_000) / 100}K"
        } else {
            result = count.toString()
        }

        textView.setText(result)
    }
}