package com.sorabh.grabfood.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val space8: Dp = 8.dp,
    val space16: Dp = 16.dp,
    val space24: Dp = 24.dp,
    val space48: Dp = 48.dp,
    val space50: Dp = 50.dp,
    val space62: Dp = 62.dp,
    val space70: Dp = 70.dp,
    val space100: Dp = 100.dp,
    val space130: Dp = 130.dp,
    val space150: Dp = 150.dp
)

val LocalSpace = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpace.current
