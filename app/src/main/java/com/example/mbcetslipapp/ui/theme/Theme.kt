package com.example.mbcetslipapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    background = Grey10,
    onBackground = Grey1,
    primary = PrimDark,
//    primaryVariant = Grey9,
    secondary = Grey1,
    surface = PrimDark,
    onSurface = Grey2,
    onPrimary = Grey1,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    background = Grey2,
    onBackground = PrimDark,
    primary = PrimBlue,
//    primaryVariant = SecViolet,
    onPrimary = Grey1,
    secondary = SecGrey1,
    onSecondary = Grey9,
    surface = PrimBlue,
)

@Composable
fun MBCETSlipAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}