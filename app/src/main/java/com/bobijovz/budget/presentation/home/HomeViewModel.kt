package com.bobijovz.budget.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobijovz.domain.interactor.GetExpenses
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(val getExpenses: GetExpenses) : ViewModel() {

    private val mExpenseModel = MutableStateFlow(emptyList<ExpenseModel>())
    val expenseModel: StateFlow<List<ExpenseModel>> = mExpenseModel

    fun loadExpenses() {
        viewModelScope.launch(Dispatchers.IO) {
            getExpenses.execute().collect { expenses ->
                mExpenseModel.value = expenses.map {
                    ExpenseModel(
                        category = it.category,
                        planned = "",
                        actual = it.price.toString()
                    )
                }
            }
        }
    }
}

