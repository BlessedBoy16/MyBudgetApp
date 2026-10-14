package com.example.mybudgetapp.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BudgetColors.Purple,
    onPrimary = BudgetColors.Black,
    primaryContainer = BudgetColors.PurplePale,
    onPrimaryContainer = BudgetColors.Gray900,
    secondary = BudgetColors.PurpleDark,
    onSecondary = BudgetColors.White,
    secondaryContainer = BudgetColors.PurplePale,
    onSecondaryContainer = BudgetColors.Gray900,
    tertiary = BudgetColors.Gray600,
    onTertiary = BudgetColors.White,
    tertiaryContainer = BudgetColors.Gray200,
    onTertiaryContainer = BudgetColors.Gray900,
    background = BudgetColors.Gray100,
    onBackground = BudgetColors.Gray900,
    surface = BudgetColors.White,
    onSurface = BudgetColors.Gray900,
    surfaceVariant = BudgetColors.PurplePale,
    onSurfaceVariant = BudgetColors.Gray600,
    surfaceTint = BudgetColors.Purple,
    surfaceDim = BudgetColors.Gray200,
    surfaceBright = BudgetColors.White,
    surfaceContainerLowest = BudgetColors.White,
    surfaceContainerLow = BudgetColors.Gray100,
    surfaceContainer = BudgetColors.Gray100,
    surfaceContainerHigh = BudgetColors.Gray200,
    surfaceContainerHighest = BudgetColors.Gray200,
    inverseSurface = BudgetColors.Gray800,
    inverseOnSurface = BudgetColors.White,
    inversePrimary = BudgetColors.PurpleLight,
    outline = BudgetColors.Gray500,
    outlineVariant = BudgetColors.Gray300,
)

private val DarkColors = darkColorScheme(
    primary = BudgetColors.PurpleLight,
    onPrimary = BudgetColors.Black,
    primaryContainer = BudgetColors.PurpleDark,
    onPrimaryContainer = BudgetColors.White,
    secondary = BudgetColors.PurpleLight,
    onSecondary = BudgetColors.Black,
    secondaryContainer = BudgetColors.Gray700,
    onSecondaryContainer = BudgetColors.PurplePale,
    tertiary = BudgetColors.Gray300,
    onTertiary = BudgetColors.Gray900,
    tertiaryContainer = BudgetColors.Gray700,
    onTertiaryContainer = BudgetColors.White,
    background = BudgetColors.Gray900,
    onBackground = BudgetColors.White,
    surface = BudgetColors.Gray800,
    onSurface = BudgetColors.White,
    surfaceVariant = BudgetColors.Gray700,
    onSurfaceVariant = BudgetColors.Gray300,
    surfaceTint = BudgetColors.PurpleLight,
    surfaceDim = BudgetColors.Gray900,
    surfaceBright = BudgetColors.Gray700,
    surfaceContainerLowest = BudgetColors.Black,
    surfaceContainerLow = BudgetColors.Gray900,
    surfaceContainer = BudgetColors.Gray800,
    surfaceContainerHigh = BudgetColors.Gray700,
    surfaceContainerHighest = BudgetColors.Gray600,
    inverseSurface = BudgetColors.Gray200,
    inverseOnSurface = BudgetColors.Gray900,
    inversePrimary = BudgetColors.PurpleDark,
    outline = BudgetColors.Gray400,
    outlineVariant = BudgetColors.Gray600,
)

@Composable
fun BudgetTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = budgetTypography(),
        content = content,
    )
}
