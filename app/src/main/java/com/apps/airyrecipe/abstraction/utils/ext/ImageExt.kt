package com.apps.airyrecipe.abstraction.util.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

fun ImageView.load(imageUri: Any) {
    Glide.with(context.getApplicationContext())
        .load(imageUri)
        .apply(RequestOptions())
        .into(this)
}

fun ImageView.circle(imageUri: Any) {
    Glide.with(context.getApplicationContext())
        .asBitmap()
        .load(imageUri)
        .apply(RequestOptions()
            .transform(CircleCrop())
        )
        .into(this)
}