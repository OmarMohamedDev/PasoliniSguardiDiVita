package com.omd.pasolinisdv.ui.detail

import com.omd.pasolinisdv.data.model.Section
import com.omd.pasolinisdv.ui.base.AbstractViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(val section: Section) : AbstractViewModel() {

    fun getTitle() = section.title

    fun getContent() = section.content

    fun getImagesIDsArray() = section.images

    fun getVideoURL() = section.videoURL

}