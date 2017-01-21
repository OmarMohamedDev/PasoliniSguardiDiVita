package com.omd.pasolinisdv.ui.section

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.omd.pasolinisdv.extensions.loadImage

@BindingAdapter("android:src")
fun setImageBinding(view: ImageView, url: String){
    view.loadImage(url)
}