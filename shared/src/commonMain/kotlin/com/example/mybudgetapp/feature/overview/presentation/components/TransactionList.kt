package com.example.mybudgetapp.feature.overview.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mybudgetapp.feature.overview.presentation.CirclePlaceholder
import com.example.mybudgetapp.core.ui.modifier.shimmer
import androidx.compose.foundation.shape.CircleShape

@Composable
fun TransactionList(modifier: Modifier = Modifier, isLoading: Boolean = false) {
    Column(modifier = modifier) {
        TransactionInfo(isLoading)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(count = if (isLoading) 4 else 10) {
                TransactionCard(isLoading)
            }
        }
    }
}

@Composable
fun TransactionCard(isLoading: Boolean = false) {
    Card() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box() {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    CirclePlaceholder(
                        text = "",
                        modifier = Modifier.shimmer(isLoading, shape = CircleShape),
                    )
                    Text(
                        text = "Cafe",
                        modifier = Modifier.shimmer(isLoading),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(text = "354.45$", modifier = Modifier.shimmer(isLoading))
                Text(text = "$4.567", modifier = Modifier.shimmer(isLoading))
            }
        }
    }
}

@Composable
fun TransactionInfo(isLoading: Boolean = false) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Transaction",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Monday, 12 January, 2026",
                modifier = Modifier.shimmer(isLoading),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = "Total $2,950",
                modifier = Modifier.shimmer(isLoading),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
