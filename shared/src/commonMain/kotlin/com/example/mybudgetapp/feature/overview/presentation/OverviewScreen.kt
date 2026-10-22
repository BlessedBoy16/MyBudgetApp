package com.example.mybudgetapp.feature.overview.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mybudgetapp.core.ui.theme.BudgetTheme
import com.example.mybudgetapp.core.ui.modifier.shimmer
import com.example.mybudgetapp.feature.overview.presentation.components.FinanceCard
import com.example.mybudgetapp.feature.overview.presentation.components.TransactionList
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OverViewScreen(
    viewModel: OverviewScreenViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Content(state = state)
}

@Composable
private fun Content(
    state: OverViewScreenState,
) {

    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Заглушка аватарки
            CirclePlaceholder(text = "АT")
            Surface(
                shape = RoundedCornerShape(24.dp),
                color = Color.Transparent.copy(alpha = .02f),
            ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 10.dp,
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text("November 2025")
                    Text("⌄")
                }
            }
            // Заглушка
            CirclePlaceholder(text = "●")
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (state.isLoading) "000 000,00" else state.balance?.toString()
                    .orEmpty(),
                modifier = Modifier.shimmer(state.isLoading),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        Spacer(Modifier.size(32.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your Money",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = Color.Transparent.copy(alpha = .02f),
                ) {
                    Row(
                        modifier = Modifier.padding(
                            horizontal = 4.dp,
                            vertical = 4.dp,
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = "Details",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FinanceCard(modifier = Modifier.weight(1f), isLoading = state.isLoading)
                FinanceCard(modifier = Modifier.weight(1f), isLoading = state.isLoading)
            }
            TransactionList(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                isLoading = state.isLoading,
            )
        }
    }
}

@Composable
fun CirclePlaceholder(
    text: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@Preview
@Composable
fun OverViewScreenPrev() {
    BudgetTheme {
        Content(
            state = OverViewScreenState()
        )
    }
}

@Preview
@Composable
fun OverViewLoadingDarkPreview() {
    BudgetTheme(darkTheme = true) {
        Content(state = OverViewScreenState(isLoading = true))
    }
}
