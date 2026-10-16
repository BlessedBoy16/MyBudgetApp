package com.example.mybudgetapp.core.ui.modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp

/** Replaces drawing and accessibility content while keeping the element's layout size.
 * Give empty elements an explicit size. This modifier does not disable click handlers.
 */
@Composable
fun Modifier.shimmer(
    isLoading: Boolean = true,
    shape: Shape = RoundedCornerShape(6.dp),
    baseColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    highlightColor: Color = MaterialTheme.colorScheme.surface,
): Modifier {
    if (!isLoading) return this

    val transition = rememberInfiniteTransition(label = "shimmer")
    val progress = transition.animateFloat(
        initialValue = -1f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1400, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "shimmerProgress",
    )

    return this
        .clearAndSetSemantics { }
        .clip(shape)
        .drawWithContent {
            if (size.width <= 0f || size.height <= 0f) return@drawWithContent
            // Read animation state during drawing, avoiding per-frame recomposition.
            val center = progress.value * size.width
            val band = size.width * 0.65f
            drawRect(baseColor)
            drawRect(
                brush = Brush.linearGradient(
                    colors = listOf(
                        baseColor.copy(alpha = 0f),
                        highlightColor.copy(alpha = 0.65f),
                        baseColor.copy(alpha = 0f),
                    ),
                    start = Offset(center - band, 0f),
                    end = Offset(center + band, size.height),
                ),
            )
        }
}
