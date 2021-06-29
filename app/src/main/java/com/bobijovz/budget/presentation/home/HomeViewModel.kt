package com.bobijovz.budget.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobijovz.domain.interactor.GetExpenses
import com.bobijovz.domain.interactor.GetIncome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel(val getExpenses: GetExpenses, val getIncome: GetIncome) : ViewModel() {

    private val mExpenseModel = MutableStateFlow(emptyList<ExpenseModel>())
    private val mIncomeModel = MutableStateFlow(emptyList<IncomeModel>())
    val expenseModel: StateFlow<List<ExpenseModel>> = mExpenseModel
    val incomeModel: StateFlow<List<IncomeModel>> = mIncomeModel

    fun loadExpenses() {
        viewModelScope.launch(Dispatchers.IO) {
            getExpenses.execute().collect { expenses ->
                mExpenseModel.value = expenses.map {
                    ExpenseModel(
                        category = it.category,
                        planned = it.planned.toString(),
                        actual = it.price.toString()
                    )
                }
            }
        }
    }

    fun loadIncome(){
        viewModelScope.launch(Dispatchers.IO){
            getIncome.execute().collect { income ->
                mIncomeModel.value = income.map {
                    IncomeModel(
                        category = it.category,
                        planned = it.planned.toString(),
                        actual = it.price.toString()
                    )
                }
            }
        }
    }
}

