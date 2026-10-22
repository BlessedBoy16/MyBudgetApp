package com.example.mybudgetapp.feature.budget.domain

import com.example.mybudgetapp.feature.overview.presentation.Money

data class CategoryBudgetStatus(
    val category: Category,
    val limit: Money?,
    val spent: Money,
)
