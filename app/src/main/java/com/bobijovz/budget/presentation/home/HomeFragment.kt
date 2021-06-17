package com.bobijovz.budget.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bobijovz.budget.R
import com.bobijovz.budget.core.extension.viewBinding
import com.bobijovz.budget.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()
    val binding by viewBinding(FragmentHomeBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadExpenses()
        val listExpense : List<ExpenseModel> = emptyList()

        Log.d("ExpenseList", listExpense.toString())

    }
}