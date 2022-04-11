package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.model.Category
import com.bobijovz.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip

class GetActivities(private val budgetRepository: BudgetRepository) {

    fun execute(): Flow<List<Activity>> {
        return budgetRepository.getCategories()
            .zip(budgetRepository.getActivities()) { categories, activities ->
                val categoryList = mutableMapOf<String, Category>()
                categories.map { item ->
                    categoryList += item.categoryId to item
                }

                activities.map { activity ->
                     Activity(
                        id = activity.id,
                        categoryId = categoryList[activity.categoryId]?.categoryName ?: "",
                        description = activity.description,
                        type = activity.type,
                        price = activity.price,
                        timestamp = activity.timestamp
                    )
                }
            }
    }
}