package com.omd.pasolinisdv.ui.detail

import dagger.Subcomponent
import com.omd.pasolinisdv.ui.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(
        DetailModule::class
))
interface DetailComponent {
    fun injectTo(activity: DetailActivity)
}