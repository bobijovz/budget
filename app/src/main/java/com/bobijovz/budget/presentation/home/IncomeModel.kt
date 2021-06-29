package com.bobijovz.budget.presentation.home

data class IncomeModel(val category: String= "",
                  val planned: String = "",
                  val actual : String = "") : ActivityBaseModel()