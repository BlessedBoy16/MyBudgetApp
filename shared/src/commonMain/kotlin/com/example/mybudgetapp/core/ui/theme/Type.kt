package com.example.mybudgetapp.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import mybudgetapp.shared.generated.resources.Res
import mybudgetapp.shared.generated.resources.inter_tight_regular
import mybudgetapp.shared.generated.resources.inter_tight_medium
import mybudgetapp.shared.generated.resources.inter_tight_semibold
import mybudgetapp.shared.generated.resources.inter_tight_bold
import org.jetbrains.compose.resources.Font

@Composable
internal fun budgetTypography(): Typography {
    val family = FontFamily(
        Font(Res.font.inter_tight_regular, FontWeight.Normal),
        Font(Res.font.inter_tight_medium, FontWeight.Medium),
        Font(Res.font.inter_tight_semibold, FontWeight.SemiBold),
        Font(Res.font.inter_tight_bold, FontWeight.Bold),
    )
    val base = Typography()
    return Typography(
        displayLarge = base.displayLarge.copy(fontFamily = family, fontWeight = FontWeight.Bold),
        displayMedium = base.displayMedium.copy(fontFamily = family, fontWeight = FontWeight.Bold),
        displaySmall = base.displaySmall.copy(fontFamily = family, fontWeight = FontWeight.Bold),
        headlineLarge = base.headlineLarge.copy(fontFamily = family, fontWeight = FontWeight.SemiBold),
        headlineMedium = base.headlineMedium.copy(fontFamily = family, fontWeight = FontWeight.SemiBold),
        headlineSmall = base.headlineSmall.copy(fontFamily = family, fontWeight = FontWeight.SemiBold),
        titleLarge = base.titleLarge.copy(fontFamily = family, fontWeight = FontWeight.SemiBold),
        titleMedium = base.titleMedium.copy(fontFamily = family),
        titleSmall = base.titleSmall.copy(fontFamily = family),
        bodyLarge = base.bodyLarge.copy(fontFamily = family),
        bodyMedium = base.bodyMedium.copy(fontFamily = family),
        bodySmall = base.bodySmall.copy(fontFamily = family),
        labelLarge = base.labelLarge.copy(fontFamily = family),
        labelMedium = base.labelMedium.copy(fontFamily = family),
        labelSmall = base.labelSmall.copy(fontFamily = family),
    )
}
