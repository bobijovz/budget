package com.bobijovz.budget.data

import com.bobijovz.budget.domain.Activity
import com.bobijovz.budget.domain.BudgetRepository
import com.bobijovz.budget.domain.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BudgetRepositoryImpl : BudgetRepository {

    override fun getActivities(): Flow<List<Activity>> = flow {
        emit(
            listOf(
                Activity("1", "2", "Test 1", 1234.00),
                Activity("2", "2", "Test 1", 333.00),
                Activity("3", "2", "Test 1", 22.00),
                Activity("4", "1", "Test 2", 12345.00),
                Activity("5", "3", "Test 3", 12346.00),
                Activity("6", "4", "Test 4", 12347.00),
                Activity("7", "4", "Test 123", 12347.00),
                Activity("8", "4", "Test 4", 12347.00),
                Activity("9", "4", "Test 4", 12347.00),
            )
        )
    }

    override fun getCategories(): Flow<List<Category>> = flow {
        emit(
            listOf(
                Category("1","Food",1000.00),
                Category("2","Utilities",2000.00),
                Category("3","Personal",3000.00),
                Category("4","Savings",4000.00)
            )
        )
    }
}