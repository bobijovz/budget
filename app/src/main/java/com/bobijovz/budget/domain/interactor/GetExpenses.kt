package com.bobijovz.budget.domain.interactor

import com.bobijovz.budget.domain.BudgetRepository
import com.bobijovz.budget.domain.Category
import com.bobijovz.budget.domain.Expense
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetExpenses(private val budgetRepository: BudgetRepository) {

    fun execute(): Flow<List<Expense>> {
        var categories = mapOf<String,List<String>>()

        return budgetRepository.getActivities().map { activities ->
            activities.groupBy { activity ->
                activity.categoryId
            }.map { groupActivity ->
                Expense(
                    groupActivity.key, 
                    groupActivity.value.map { value -> value.price }.sum())
            }
        }
    }
}