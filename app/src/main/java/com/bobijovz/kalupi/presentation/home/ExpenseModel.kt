package com.bobijovz.kalupi.presentation.home

data class ExpenseModel(val category: String= "",
                   val planned: String = "",
                   val actual : String = "") : ActivityBaseModel()