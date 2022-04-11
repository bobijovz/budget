package com.bobijovz.domain.repository

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.model.Category
import kotlinx.coroutines.flow.Flow


interface BudgetRepository {
    fun getActivities() : Flow<List<Activity>>
    fun getCategories() : Flow<List<Category>>
    fun addActivity(data: Activity)
}