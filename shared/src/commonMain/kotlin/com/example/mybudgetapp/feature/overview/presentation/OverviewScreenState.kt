package com.example.mybudgetapp.feature.overview.presentation

import com.example.mybudgetapp.feature.overview.domain.MonthlyOverview
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.time.Clock


val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

data class OverViewScreenState(
    val selectedMonth: LocalDate = LocalDate(today.year, today.month, 1),
    val balance: Money? = null,
    val isBalanceLoading: Boolean = true,
    val balanceError: String? = null,
    val overview: MonthlyOverview? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)

data class Money(
    val amountMinor: Long,
    val currencyCode: String,
)