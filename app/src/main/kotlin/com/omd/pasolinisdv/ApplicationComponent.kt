package com.omd.pasolinisdv

import dagger.Component
import com.omd.pasolinisdv.data.network.NetworkModule
import com.omd.pasolinisdv.data.remote.ApiModule
import com.omd.pasolinisdv.ui.detail.DetailComponent
import com.omd.pasolinisdv.ui.detail.DetailModule
import com.omd.pasolinisdv.ui.list.ListComponent
import com.omd.pasolinisdv.ui.list.ListModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class,
        ApiModule::class
))
interface ApplicationComponent {

    // Injectors
    fun injectTo(app: PasoliniSguardiDiVitaApp)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: ListModule): ListComponent
    fun plus(module: DetailModule): DetailComponent
}