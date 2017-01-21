package com.omd.pasolinisdv.ui.section

import com.omd.pasolinisdv.data.model.Section
import com.omd.pasolinisdv.ui.base.AbstractViewModel
import javax.inject.Inject

class SectionViewModel @Inject constructor(val section: Section) : AbstractViewModel() {

    fun getTitle() = section.title

    fun getContent() = section.content

    fun getImagesIDsArray() = section.images

    fun getVideoURL() = section.videoURL

}