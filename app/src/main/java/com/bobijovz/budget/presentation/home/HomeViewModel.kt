package com.bobijovz.budget.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val mExpenseModel = MutableStateFlow(ExpenseModel())
    val expenseModel: StateFlow<ExpenseModel> = mExpenseModel

    fun loadExpenses() {
        viewModelScope.launch {

        }
    }


}
