package com.omd.pasolinisdv.ui.list

import com.omd.pasolinisdv.data.remote.model.Repo
import com.omd.pasolinisdv.ui.base.AbstractViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RepoViewModel(val repo: Repo) : AbstractViewModel() {

    private val clicks = PublishSubject.create<Unit>()

    fun getName() = repo.fullName

    fun getDescription() = repo.description

    fun onClick() {
        clicks.onNext(Unit)
    }

    fun clicks(): Observable<Unit> = clicks.hide()
}