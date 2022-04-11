package com.bobijovz.data.repository

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.repository.BudgetRepository
import com.bobijovz.domain.model.Category
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BudgetRepositoryImpl(val database: FirebaseDatabase) : BudgetRepository {

    //val database: FirebaseDatabase = FirebaseDatabase.getInstance()


    override fun getActivities(): Flow<List<Activity>> = flow {
        emit(
            listOf(
                Activity("1", "2", "Test 1", "expense",10000.00, 1624963974),
                Activity("2", "1", "Test 2", "expense",10000.00, 1624963974),
                Activity("3", "3", "Test 3", "expense",10000.00, 1624963974),
                Activity("4", "4", "Test 4", "expense",10000.00, 1624963974),
                Activity("5", "4", "Test 4", "expense",10000.00, 1624963974),
                Activity("6", "4", "Test 4", "expense",10000.00, 1624963974),
                Activity("7", "4", "Test 4", "expense",10000.00, 1624963974),
                Activity("8", "4", "Test 4", "expense",10000.00, 1624963974),
                Activity("9", "6", "Test 2342", "income",10000.00, 1624963974),
                Activity("10", "5", "Test 21242", "income",100000.00, 1624963974)
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

    override fun addActivity(data: Activity) {
        //val myRef: DatabaseReference = database.getReference("activities")
       // myRef.setValue("Hello, Bobi!")

    }


}