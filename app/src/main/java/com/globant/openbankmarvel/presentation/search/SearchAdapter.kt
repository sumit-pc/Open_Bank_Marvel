package com.globant.openbankmarvel.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.globant.domain.model.HeroData
import com.globant.openbankmarvel.databinding.ViewHolderSearchListBinding

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var listener: ((HeroData) -> Unit)? = null
    private var list = mutableListOf<HeroData>()

    fun setContentList(list: MutableList<HeroData>) {
        this.list = list
        notifyDataSetChanged()
    }


    class SearchViewHolder(val viewHolder: ViewHolderSearchListBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchViewHolder {
        val binding =
            ViewHolderSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    fun itemClickListener(l: (HeroData) -> Unit) {
        listener = l
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.viewHolder.meal = this.list[position]

        holder.viewHolder.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
            listener?.invoke(this.list[position])
        }

    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}