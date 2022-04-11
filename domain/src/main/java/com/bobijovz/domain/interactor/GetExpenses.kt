package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Category
import com.bobijovz.domain.model.Expense
import com.bobijovz.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip

class GetExpenses(private val budgetRepository: BudgetRepository) {

    fun execute(): Flow<List<Expense>> {

        return budgetRepository.getCategories()
            .zip(budgetRepository.getActivities()) { categories, activities ->
                val categoryList = mutableMapOf<String, Category>()
                categories.map { item ->
                    categoryList += item.categoryId to item
                }

                println("categories: $categories")
                activities.filter { it.type == "expense" }
                    .groupBy { activity -> activity.categoryId }
                    .map { groupActivity ->
                        Expense(
                            categoryList[groupActivity.key]?.categoryName ?: "",
                            categoryList[groupActivity.key]?.categoryPlanned ?: 0.0,
                            groupActivity.value.map { value -> value.price }.sum()
                        )
                    }
            } 
    }
}