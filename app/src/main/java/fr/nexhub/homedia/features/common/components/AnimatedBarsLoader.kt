package fr.nexhub.homedia.features.common.components

import allIconColors
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedBarsLoader(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AnimatedBars()
    }
}

@Composable
fun AnimatedBars(
    modifier: Modifier = Modifier,
    barCount: Int = 5,
    colors: Array<Color> = allIconColors,
    barWidth: Dp = 20.dp,
    maxHeight: Dp = 100.dp,
    cornerRadius: Dp = 8.dp
) {
    val infiniteTransition = rememberInfiniteTransition(label = "InfiniteTransition")
    val animations = (0 until barCount).map { index ->
        infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 400, easing = LinearEasing, delayMillis = index * 100),
                repeatMode = RepeatMode.Reverse
            ), label = "AnimateFloat"
        )
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        animations.forEachIndexed { index, anim ->
            Canvas(modifier = Modifier.size(barWidth, maxHeight)) {
                val barHeight = maxHeight.toPx() * anim.value
                drawRoundRect(
                    color = colors[index % colors.size],
                    topLeft = Offset(0f, size.height - barHeight),
                    size = Size(barWidth.toPx(), barHeight),
                    cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx()),
                    style = Fill
                )
            }
        }
    }
}
