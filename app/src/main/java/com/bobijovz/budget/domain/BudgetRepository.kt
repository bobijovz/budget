package com.bobijovz.budget.domain

import kotlinx.coroutines.flow.Flow

interface BudgetRepository {
    fun getActivities() : Flow<List<Activity>>
}