package com.example.mybudgetapp.feature.overview.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OverViewScreenViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(OverViewScreenState.Content())
    val uiState = _uiState.asStateFlow()
}