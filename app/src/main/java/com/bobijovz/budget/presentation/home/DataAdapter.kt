package com.bobijovz.budget.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bobijovz.budget.databinding.ItemDataLayoutBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    private var items: List<ActivityBaseModel> = emptyList()
    private var isExpense : Boolean = true

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
        if (isExpense){
            val item = items[position] as ExpenseModel
            holder.binding.tvCategoryName.text = item.category
            holder.binding.tvActualValue.text = item.actual
            holder.binding.tvPlannedValue.text = item.planned
        } else {
            val item = items[position] as IncomeModel
            holder.binding.tvCategoryName.text = item.category
            holder.binding.tvActualValue.text = item.actual
            holder.binding.tvPlannedValue.text = item.planned
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateIncomeList(items: List<IncomeModel>){
        this.items = items
        this.isExpense = false
        Log.d("ExpenseListAdapter", items.toString())
        notifyDataSetChanged()
    }

    fun updateExpenseList(items: List<ExpenseModel>){
        this.items = items
        this.isExpense = true
        Log.d("ExpenseListAdapter", items.toString())
        notifyDataSetChanged()
    }


}