package com.example.candles.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = ForestGreen,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBBDFBB),
    onPrimaryContainer = ForestGreenDark,

    secondary = SoftBrown,
    onSecondary = Color.White,
    secondaryContainer = SoftSand,
    onSecondaryContainer = DeepBrown,

    tertiary = GoldAccent,
    onTertiary = Color.White,
    tertiaryContainer = GoldLight,
    onTertiaryContainer = DeepBrown,

    background = WarmBeige,
    onBackground = ElegantDark,
    surface = CreamWhite,
    onSurface = ElegantDark,
    surfaceVariant = SoftSand,
    onSurfaceVariant = ElegantDarkSecondary,

    error = ErrorRed,
    onError = Color.White,
    errorContainer = Color(0xFFFDE8E5),
    onErrorContainer = Color(0xFF8B1A1A),

    outline = Color(0xFFC4B9A8),
    outlineVariant = Color(0xFFE0D6C8),
    inverseSurface = ElegantDark,
    inverseOnSurface = WarmBeige,
    inversePrimary = ForestGreenLight,
    surfaceTint = ForestGreen,
)

private val DarkColorScheme = darkColorScheme(
    primary = ForestGreenMuted,
    onPrimary = Color.White,
    primaryContainer = ForestGreenDark,
    onPrimaryContainer = Color(0xFFBBDFBB),

    secondary = SoftBrownDark,
    onSecondary = Color.White,
    secondaryContainer = DeepBrown,
    onSecondaryContainer = SoftSand,

    tertiary = GoldAccentDark,
    onTertiary = Color.Black,
    tertiaryContainer = Color(0xFF5C4A1E),
    onTertiaryContainer = GoldLight,

    background = DarkBackground,
    onBackground = Color(0xFFE8E0D4),
    surface = DarkSurface,
    onSurface = Color(0xFFE8E0D4),
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = Color(0xFFCAC0B0),

    error = ErrorRedLight,
    onError = Color.White,
    errorContainer = Color(0xFF5C1A1A),
    onErrorContainer = Color(0xFFFDE8E5),

    outline = Color(0xFF6B6050),
    outlineVariant = Color(0xFF4A4030),
    inverseSurface = WarmBeige,
    inverseOnSurface = ElegantDark,
    inversePrimary = ForestGreen,
    surfaceTint = ForestGreenMuted,
)

@Composable
fun CandlesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            @Suppress("DEPRECATION")
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
