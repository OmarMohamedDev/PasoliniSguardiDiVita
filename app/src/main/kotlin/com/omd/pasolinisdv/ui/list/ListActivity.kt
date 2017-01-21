package com.omd.pasolinisdv.ui.list

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.omd.pasolinisdv.ApplicationComponent
import com.omd.pasolinisdv.R
import com.omd.pasolinisdv.data.model.Repo
import com.omd.pasolinisdv.databinding.ActivityListBinding
import com.omd.pasolinisdv.extensions.hide
import com.omd.pasolinisdv.extensions.show
import com.omd.pasolinisdv.extensions.showSnackbar
import com.omd.pasolinisdv.ui.base.ViewModelActivity
import com.omd.pasolinisdv.ui.detail.DetailActivity
import com.omd.pasolinisdv.ui.misc.SimpleDividerItemDecoration
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ListActivity : ViewModelActivity<ListViewModel, ActivityListBinding>() {

    @Inject
    lateinit var adapter: RepoAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var dividerDecorator: SimpleDividerItemDecoration

    val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.listToolbar)
    }

    override fun onBind() {
        super.onBind()
        binding.viewModel = viewModel
        setupRecyclerView()
        setupSwipeRefresh()
        updateEmptyView()

        disposables.add(viewModel.getRepos().subscribe {
            updateList(it)
        })

        disposables.add(viewModel.loadingState().subscribe {
            binding.listSwipeRefresh.isRefreshing = it
        })

        disposables.add(viewModel.fetchErrors().subscribe {
            errorFetchRepos()
        })

        disposables.add(viewModel.networkErrors().subscribe {
            errorNoNetwork()
        })
    }

    override fun getViewBinding(): ActivityListBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_list)
    }

    private fun setupSwipeRefresh() {
        binding.listSwipeRefresh.setOnRefreshListener {
            viewModel.fetchRepos()
        }
    }

    private fun setupRecyclerView() {
        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = layoutManager
        binding.listRecyclerView.addItemDecoration(dividerDecorator)

        adapter.setClickListener {
            onItemClick(it)
        }
    }

    override fun injectDependencies(graph: ApplicationComponent) {
        graph.plus(ListModule(this))
                .injectTo(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun onItemClick(section: Repo) {
        startActivity(DetailActivity.newIntent(this, section))
    }

    private fun updateList(sections: List<Repo>) {
        adapter.updateRepos(sections)
        updateEmptyView()
    }

    private fun updateEmptyView() {
        if (adapter.itemCount == 0) {
            binding.emptyView.root.show()
        } else {
            binding.emptyView.root.hide()
        }
    }

    private fun errorNoNetwork() {
        binding.listCoordinatorLayout.showSnackbar(R.string.list_error_no_network)
    }

    private fun errorFetchRepos() {
        binding.listCoordinatorLayout.showSnackbar(R.string.list_error_failed_fetch)
    }

    override fun onPause() {
        super.onPause()
        disposables.clear()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                Timber.d("Settings menu clicked!")
                true
            }

            R.id.action_night -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                recreate()
                true
            }

            R.id.action_day -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                recreate()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
