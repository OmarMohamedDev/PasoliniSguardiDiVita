package com.omd.pasolinisdv.ui.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.omd.pasolinisdv.ApplicationComponent
import com.omd.pasolinisdv.PasoliniSguardiDiVitaApp
import com.omd.pasolinisdv.R
import com.omd.pasolinisdv.data.model.Section
import com.omd.pasolinisdv.ui.section.SectionActivity
import kotlinx.android.synthetic.main.activity_section.*

abstract class BaseActivity: AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        injectDependencies(PasoliniSguardiDiVitaApp.graph)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            item ->
                val intent: Intent
                val titleId: Int
                val contentId: Int
                val imageIdArray: IntArray
                val videoUrl: String

                when (item.itemId) {
                    R.id.action_rome -> {
                       titleId = R.string.pasolini_roma_title
                       contentId = R.string.pasolini_roma_content
                       imageIdArray = intArrayOf(1, 2, 3)
                       videoUrl = "videoUrl"
                    }
                    R.id.action_monteverde -> {
                        titleId = R.string.pasolini_monteverde_title
                        contentId = R.string.pasolini_monteverde_content
                        imageIdArray = intArrayOf(1, 2, 3)
                        videoUrl = "videoUrl"
                    }
                    R.id.action_tour -> {
                        //TODO: change this properly
                        titleId = R.string.pasolini_monteverde_title
                        contentId = R.string.pasolini_monteverde_content
                        imageIdArray = intArrayOf(1, 2, 3)
                        videoUrl = "videoUrl"
                    }
                    R.id.action_augmented_reality -> {
                        //TODO: change this properly
                        titleId = R.string.pasolini_monteverde_title
                        contentId = R.string.pasolini_monteverde_content
                        imageIdArray = intArrayOf(1, 2, 3)
                        videoUrl = "videoUrl"
                    }
                    else -> {
                        titleId = R.string.pasolini_roma_title
                        contentId = R.string.pasolini_roma_content
                        imageIdArray = intArrayOf(1, 2, 3)
                        videoUrl = "videoUrl"
                    }
                 }

            intent = SectionActivity.newIntent(this, Section(getString(titleId),
                    getString(contentId),
                    imageIdArray,
                    videoUrl))

        }
    }

    abstract fun injectDependencies(graph: ApplicationComponent)
}
