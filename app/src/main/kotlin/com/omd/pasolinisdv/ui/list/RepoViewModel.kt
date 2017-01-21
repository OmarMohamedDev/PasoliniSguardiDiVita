package com.omd.pasolinisdv.ui.list

import com.omd.pasolinisdv.data.model.Repo
import com.omd.pasolinisdv.ui.base.AbstractViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RepoViewModel(val section: Repo) : AbstractViewModel() {

    private val clicks = PublishSubject.create<Unit>()

    fun getName() = section.fullName

    fun getDescription() = section.description

    fun onClick() {
        clicks.onNext(Unit)
    }

    fun clicks(): Observable<Unit> = clicks.hide()
}