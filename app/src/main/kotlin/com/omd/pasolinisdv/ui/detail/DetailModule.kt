package com.omd.pasolinisdv.ui.detail

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import com.omd.pasolinisdv.data.remote.model.Repo
import com.omd.pasolinisdv.ui.base.ActivityModule

@Module
class DetailModule(activity: AppCompatActivity, val repo: Repo) : ActivityModule(activity) {

    @Provides
    fun provideRepo(): Repo = repo
}