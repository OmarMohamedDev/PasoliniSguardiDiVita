package com.omd.pasolinisdv.ui.section

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.omd.pasolinisdv.ApplicationComponent
import com.omd.pasolinisdv.R
import com.omd.pasolinisdv.data.model.Section
import com.omd.pasolinisdv.databinding.ActivitySectionBinding
import com.omd.pasolinisdv.extensions.enableToolbarBackButton
import com.omd.pasolinisdv.ui.base.ViewModelActivity

open class SectionActivity : ViewModelActivity<SectionViewModel, ActivitySectionBinding>() {

    companion object {
        val EXTRA_SECTION_OBJECT = "SECTION_ITEM"

        fun newIntent(context: Context, section: Section): Intent {
            val intent = Intent(context, SectionActivity::class.java)
            intent.putExtra(EXTRA_SECTION_OBJECT, section)
            return intent
        }
    }

    private lateinit var section: Section

    override fun onCreate(savedInstanceState: Bundle?) {
        // We need to inject our Book into the Dagger graph
        // Thus we need grab it from the intent before we inject dependencies in super.onCreate()
        section = intent.getParcelableExtra(EXTRA_SECTION_OBJECT)

        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.detailToolbar)
        enableToolbarBackButton()
    }

    override fun onBind() {
        super.onBind()
        binding.viewModel = viewModel
    }

    override fun getViewBinding(): ActivitySectionBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_section)
    }

    override fun injectDependencies(graph: ApplicationComponent) {
        graph.plus(SectionModule(this, section))
                .injectTo(this)
    }
}
