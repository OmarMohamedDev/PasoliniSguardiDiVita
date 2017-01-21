package com.omd.pasolinisdv.ui.section

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import com.omd.pasolinisdv.data.model.Section
import com.omd.pasolinisdv.ui.base.ActivityModule

@Module
class SectionModule(activity: AppCompatActivity, val section: Section) : ActivityModule(activity) {

    @Provides
    fun provideSection(): Section = section
}