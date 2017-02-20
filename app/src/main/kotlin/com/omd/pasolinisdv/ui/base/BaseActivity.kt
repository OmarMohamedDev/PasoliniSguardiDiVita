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
            item -> {
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
                       videoUrl = videoUrl
                    }
                    R.id.action_monteverde ->
                        R.id.action_tour ->
                    R.id.action_augmented_reality ->
                 }

                intent = SectionActivity.newIntent(this, Section(getString(titleId),
                        getString(contentId),
                        imageIdArray,
                        videoUrl))


            }
        }
        new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:

                            case R.id.action_schedules:

                            case R.id.action_music:

                        }
                        return true;
                    }
                });
        view raw
    }

    abstract fun injectDependencies(graph: ApplicationComponent)
}