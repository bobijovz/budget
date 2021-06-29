package com.bobijovz.budget.presentation.home

import android.content.res.ColorStateList
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobijovz.budget.R
import com.bobijovz.budget.core.extension.viewBinding
import com.bobijovz.budget.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel by viewModel<HomeViewModel>()
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private lateinit var expenseAdapter: DataAdapter
    private lateinit var incomeAdapter: DataAdapter
    private var balance: Double = 0.0
    private var expenses: Double = 0.0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expenseAdapter = DataAdapter()
        incomeAdapter = DataAdapter()
        binding.rvExpenseDataList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvExpenseDataList.adapter = expenseAdapter

        binding.rvIncomeDataList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvIncomeDataList.adapter = incomeAdapter

        lifecycleScope.launchWhenCreated {
            viewModel.incomeModel.collect { income ->
                incomeAdapter.updateIncomeList(items = income)
                balance = income.map { item -> item.actual.toDouble() }.sum()
                binding.tvItemIncomeTotal.text = balance.toString()
                updateBalance()
                Log.d("IncomeList", income.toString())
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.expenseModel.collect { expense ->
                expenseAdapter.updateExpenseList(items = expense)
                expenses = expense.map { item -> item.actual.toDouble() }.sum()
                binding.tvItemExpenseTotal.text = expenses.toString()
                updateBalance()
                Log.d("ExpenseList", expense.toString())
            }
        }


        viewModel.loadExpenses()
        viewModel.loadIncome()
    }


    private fun updateBalance() {
        val percentage = (100 - ((expenses * 100) / balance)).toInt()
        binding.tvBalanceValue.text = (balance - expenses).toString()
        binding.pbBalanceBar.max = balance.toInt()
        binding.pbBalanceBar.progress = (balance - expenses).toInt()
        binding.pbBalanceBar.progressDrawable = getColor(percentage)
        binding.tvPercentageValue.text = "$percentage %"
    }

    private fun getColor(percentage: Int) : Drawable {
        return if (percentage <= 20) {
            resources.getDrawable(R.drawable.bg_progress_empty)
        } else if (percentage in 21..49) {
            resources.getDrawable(R.drawable.bg_progress_low)
        } else {
            resources.getDrawable(R.drawable.bg_progress_high)
        }
    }


}