package com.omd.pasolinisdv.data.model

import android.os.Parcel

data class Section(

        val title: String,

        val content: String,

        val images: IntArray,

        val videoURL: String

) : DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(title, content, images, videoURL)
    }

    companion object {
        @JvmField val CREATOR = DefaultParcelable.generateCreator {
            Section(it.read(), it.read(), it.read(), it.read())
        }
    }
}