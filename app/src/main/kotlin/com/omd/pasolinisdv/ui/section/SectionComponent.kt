package com.omd.pasolinisdv.ui.section

import dagger.Subcomponent
import com.omd.pasolinisdv.ui.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(
        SectionModule::class
))
interface SectionComponent {
    fun injectTo(activity: SectionActivity)
}