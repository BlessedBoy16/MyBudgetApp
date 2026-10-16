package com.example.mybudgetapp.feature.overview.presentation

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.time.Clock


sealed class OverViewScreenState {
    data class Content(
        val expense: Expense? = null,
        val income: Income? = null,
        val totalAmount: Money? = null,
        val transactions: List<Transaction>? = emptyList()
    ) : OverViewScreenState()

    data class UiState(
        val isLoading: Boolean = true,
        val isRefreshing: Boolean = false,
        val selectedMonth: LocalDate = Clock.System.todayIn(TimeZone.currentSystemDefault())
    ) : OverViewScreenState()
}

data class Transaction(
    val imgTransaction: String? = null,
    val nameTransaction: String? = null,
    val income: Income? = null,
    val expense: Expense? = null,
    val date: LocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
)

data class Expense(
    val id: String,
    val amount: Money,
    val date: LocalDateTime,
    val categoryId: String,
)

data class Income(
    val id: String,
    val amount: Money,
    val date: LocalDateTime,
)

data class Money(
    val amountMinor: Long,
    val currencyCode: String,
)