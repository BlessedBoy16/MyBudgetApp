package com.example.mybudgetapp.feature.overview.domain

import com.example.mybudgetapp.feature.budget.domain.CategoryBudgetStatus
import com.example.mybudgetapp.feature.overview.presentation.Money

data class MonthlyOverview(
    val income: Money,
    val expense: Money,
    val difference: Money,
    val categories: List<CategoryBudgetStatus>,
)