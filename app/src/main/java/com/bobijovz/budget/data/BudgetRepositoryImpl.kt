package com.bobijovz.budget.data

import com.bobijovz.budget.domain.Activity
import com.bobijovz.budget.domain.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BudgetRepositoryImpl : BudgetRepository {

    override fun getActivities(): Flow<List<Activity>> = flow {
        emit(
            listOf(
                Activity("1", "2", "Test 1", 1234),
                Activity("2", "1", "Test 2", 12345),
                Activity("3", "3", "Test 3", 12346),
                Activity("4", "4", "Test 4", 12347)
            )
        )
    }
}