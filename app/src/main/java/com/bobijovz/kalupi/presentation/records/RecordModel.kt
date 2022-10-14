package com.bobijovz.kalupi.presentation.records

data class RecordModel(
    val id: String,
    val category: String,
    val description: String,
    val price: Double,
    val timestamp: Long
)