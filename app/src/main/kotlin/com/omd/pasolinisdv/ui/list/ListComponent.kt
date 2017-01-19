package com.omd.pasolinisdv.ui.list

import dagger.Subcomponent
import com.omd.pasolinisdv.ui.ActivityScope

@ActivityScope
@Subcomponent(modules = arrayOf(
        ListModule::class
))
interface ListComponent {

    fun injectTo(activity: ListActivity)
}