package com.example.mybudgetapp.feature.overview.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mybudgetapp.feature.overview.presentation.CirclePlaceholder
import com.example.mybudgetapp.core.ui.modifier.shimmer


@Composable
fun FinanceCard(modifier: Modifier = Modifier, isLoading: Boolean = false) {
    Card(modifier) {
        Column(
            Modifier.fillMaxWidth().padding(8.dp)
        ) {
            CirclePlaceholder(text = "")
            Spacer(Modifier.size(16.dp))
            Text(text = "income")
            Spacer(Modifier.size(8.dp))
            Text(text = "$4,875.12", modifier = Modifier.shimmer(isLoading))
        }
    }
}
