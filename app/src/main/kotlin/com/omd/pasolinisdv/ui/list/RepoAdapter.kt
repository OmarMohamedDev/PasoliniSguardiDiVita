package com.omd.pasolinisdv.ui.list

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.omd.pasolinisdv.R
import com.omd.pasolinisdv.data.model.Repo
import com.omd.pasolinisdv.databinding.ItemRepoBinding
import com.omd.pasolinisdv.ui.ActivityScope
import javax.inject.Inject

@ActivityScope
class RepoAdapter @Inject constructor() : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var sections: List<Repo> = emptyList()
    private var itemClick: ((Repo) -> Unit)? = null

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val binding = holder.binding
        val section = sections[position]
        var viewModel = binding.viewModel

        // Unbind old  iewModel if we have one
        viewModel?.unbind()

        // Create new ViewModel, set it, and bind it
        viewModel = RepoViewModel(section)
        binding.viewModel = viewModel
        viewModel.bind()

        holder.setClickListener(itemClick)
    }

    override fun getItemCount(): Int = sections.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = DataBindingUtil.inflate<ItemRepoBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_section,
                parent,
                false
        )

        return RepoViewHolder(binding)
    }

    fun updateRepos(sections: List<Repo>) {
        val diff = RepoDiffCallback(this.sections, sections)
        val result = DiffUtil.calculateDiff(diff)

        this.sections = sections
        result.dispatchUpdatesTo(this)
    }

    fun setClickListener(itemClick: ((Repo) -> Unit)?) {
        this.itemClick = itemClick
    }

    class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setClickListener(callback: ((Repo) -> Unit)?){
            binding.viewModel.clicks().subscribe {
                callback?.invoke(binding.viewModel.section)
            }
        }

    }
}