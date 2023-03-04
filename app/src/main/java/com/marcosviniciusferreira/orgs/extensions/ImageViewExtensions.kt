package com.marcosviniciusferreira.orgs.extensions

import android.widget.ImageView
import android.widget.Toast
import coil.load
import com.marcosviniciusferreira.orgs.R

fun ImageView.tryLoadImage(url: String? = null) {
    load(url) {
        fallback(R.drawable.product_image_not_found)
        error(R.drawable.product_image_not_found)

        listener(onError = { _, _ ->
            Toast.makeText(
                context,
                "Fail to load image URL",
                Toast.LENGTH_SHORT
            ).show()
        })
    }
}