package com.example.admin.mfvtest.Helper

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.admin.mfvtest.R

/**
 * Created by admin on 10/20/2018.
 */


 class GlideHelper {
    companion object {
        private val FIT_SCALE_SIZE_DOWNLOADER = 800
        private val FIT_DURATION_TRANSITION = 800
        private var requestOption: RequestOptions = RequestOptions()
        fun loadUrl(context: Context, imageView: ImageView, path: String) {
            Glide.with(context)
                    .load(path)
                    .apply(requestOption
                            .fitCenter()
                            .circleCrop()
//                            .centerCrop()
                            .override(FIT_SCALE_SIZE_DOWNLOADER,FIT_SCALE_SIZE_DOWNLOADER)
                            .placeholder(R.drawable.shape_loading)
                            .error(R.color.color_no_image))
                    .transition(DrawableTransitionOptions.withCrossFade(FIT_DURATION_TRANSITION))
                    .into(imageView)
        }
    }
}