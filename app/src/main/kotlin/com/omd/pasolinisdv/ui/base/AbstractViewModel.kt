package com.omd.pasolinisdv.ui.base

import android.databinding.BaseObservable

abstract class AbstractViewModel : BaseObservable(),  ViewModel {

    override fun bind() {
    }

    override fun unbind() {
    }

    override fun onDestroy() {
        // Hook for subclasses to clean up used resources
    }
}