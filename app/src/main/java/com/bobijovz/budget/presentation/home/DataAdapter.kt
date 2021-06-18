package com.bobijovz.budget.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobijovz.budget.databinding.ItemDataLayoutBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var items: List<ExpenseModel> = emptyList()

    class ViewHolder(val binding: ItemDataLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDataLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvCategoryName.text = items[position].category
        holder.binding.tvActualValue.text = items[position].actual
        holder.binding.tvPlannedValue.text = items[position].planned
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateList(items: List<ExpenseModel>){
        this.items = items
        Log.d("ExpenseListAdapter", items.toString())
        notifyDataSetChanged()
    }
}