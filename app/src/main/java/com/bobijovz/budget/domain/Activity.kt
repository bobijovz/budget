package com.bobijovz.budget.domain

data class Activity(
    val id: String,
    val categoryId: String,
    val description: String,
    val price: Int
)