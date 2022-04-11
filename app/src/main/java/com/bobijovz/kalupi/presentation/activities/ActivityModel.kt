package com.bobijovz.kalupi.presentation.activities

data class ActivityModel(
    val id: String,
    val category: String,
    val description: String,
    val price: Double,
    val timestamp: Long
)