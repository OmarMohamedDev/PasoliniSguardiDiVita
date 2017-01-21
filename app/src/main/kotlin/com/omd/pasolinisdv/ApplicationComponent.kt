package com.omd.pasolinisdv

import dagger.Component
import com.omd.pasolinisdv.data.network.NetworkModule
import com.omd.pasolinisdv.ui.section.SectionComponent
import com.omd.pasolinisdv.ui.section.SectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        NetworkModule::class
))
interface ApplicationComponent {

    // Injectors
    fun injectTo(app: PasoliniSguardiDiVitaApp)

    // Submodule methods
    // Every screen is its own submodule of the graph and must be added here.
    fun plus(module: SectionModule): SectionComponent
}