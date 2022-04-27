package com.globant.openbankmarvel.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.globant.openbankmarvel.R


@BindingAdapter("urlToImage","extensionOfImage")
fun urlToImage(view: ImageView, url: String?, extension:String?) {
    "$url.$extension"?.let {
        val options = RequestOptions.placeholderOf(R.drawable.load).error(R.drawable.error)
        Glide.with(view).setDefaultRequestOptions(options).load(it).into(view)
    }
}



