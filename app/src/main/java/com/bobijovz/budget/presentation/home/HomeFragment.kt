package com.bobijovz.budget.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
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



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expenseAdapter = DataAdapter()
        binding.rvExpenseDataList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvExpenseDataList.adapter = expenseAdapter

        lifecycleScope.launchWhenCreated {
            viewModel.expenseModel.collect { expense ->
                expenseAdapter.updateList(items = expense)
                binding.tvItemExpenseTotal.text =
                    expense.map { item -> item.actual.toDouble() }.sum().toString()
                Log.d("ExpenseList", expense.toString())
            }
        }
        viewModel.loadExpenses()
    }
}