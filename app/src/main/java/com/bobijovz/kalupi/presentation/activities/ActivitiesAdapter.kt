package com.bobijovz.kalupi.presentation.activities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobijovz.kalupi.databinding.ItemActivityLayoutBinding


class ActivitiesAdapter : RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {
    private var items: List<ActivityModel> = emptyList()

    class ViewHolder(val binding: ItemActivityLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemActivityLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvColumnId.text = item.id
        holder.binding.tvColumnCategory.text = item.category
        holder.binding.tvColumnDescription.text = item.description
        holder.binding.tvColumnValue.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(items: List<ActivityModel>) {
        this.items = items
        notifyDataSetChanged()
    }


}