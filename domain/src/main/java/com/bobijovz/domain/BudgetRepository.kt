package com.bobijovz.domain

import kotlinx.coroutines.flow.Flow


interface BudgetRepository {
    fun getActivities() : Flow<List<Activity>>
    fun getCategories() : Flow<List<Category>>
}