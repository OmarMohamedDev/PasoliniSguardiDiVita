package com.omd.pasolinisdv.ui.list

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides
import com.omd.pasolinisdv.ui.base.ActivityModule

@Module
class ListModule(activity: AppCompatActivity) : ActivityModule(activity) {

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager = LinearLayoutManager(context)
}
