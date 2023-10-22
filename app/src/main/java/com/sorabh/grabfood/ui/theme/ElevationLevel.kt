package com.sorabh.grabfood.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ElevationLevel(
    val level0:Dp = 0.dp,
    val level1: Dp = 1.dp,
    val level2: Dp = 3.dp,
    val level3: Dp = 6.dp,
    val level4: Dp = 8.dp,
    val level5: Dp = 12.dp
    )

val LocalElevationLevel = compositionLocalOf { ElevationLevel() }

val MaterialTheme.elevationLevel: ElevationLevel
    @Composable
    @ReadOnlyComposable
    get() = LocalElevationLevel.current
