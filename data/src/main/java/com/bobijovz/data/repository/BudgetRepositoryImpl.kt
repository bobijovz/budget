package com.bobijovz.data.repository

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.repository.BudgetRepository
import com.bobijovz.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BudgetRepositoryImpl : BudgetRepository {

    override fun getActivities(): Flow<List<Activity>> = flow {
        emit(
            listOf(
                Activity("3", "2", "Test 1", "expense",10000.00),
                Activity("4", "1", "Test 2", "expense",10000.00),
                Activity("5", "3", "Test 3", "expense",10000.00),
                Activity("6", "4", "Test 4", "expense",10000.00),
                Activity("6", "4", "Test 4", "expense",10000.00),
                Activity("6", "4", "Test 4", "expense",10000.00),
                Activity("6", "4", "Test 4", "expense",10000.00),
                Activity("6", "4", "Test 4", "expense",10000.00),
                Activity("10", "6", "Test 2342", "income",100000.00)
            )
        )
    }

    override fun getCategories(): Flow<List<Category>> = flow {
        emit(
            listOf(
                Category("1", "Food", 1000.00),
                Category("2", "Utilities", 2000.00),
                Category("3", "Personal", 3000.00),
                Category("4", "Savings", 4000.00),
                Category("5", "Payroll", 10000.00),
                Category("6", "Sideline", 10000.00)
            )
        )
    }
}