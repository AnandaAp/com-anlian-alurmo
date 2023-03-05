package com.anlian.alurmo.ui.theme

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import com.anlian.alurmo.R
import com.anlian.alurmo.ui.view.TAG
import androidx.compose.material.MaterialTheme as Material2Theme
import androidx.compose.material3.MaterialTheme as Material3Theme

@Composable
private fun materialDarkColor() = darkColors(
    primary = RubyRed,
    secondary = SandyBrown,
    onPrimary = colorResource(id = R.color.white)
)

@Composable
private fun materialLightColor() = lightColors(
    primary = AmaranthPurple,
    onPrimary = colorResource(id = R.color.black),
    primaryVariant = TyrianPurple,
    secondary = MellowApricot,
    surface = CherryBlossomPink

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),

    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
private fun material3DarkColor() = darkColorScheme(
    primary = RubyRed,
    secondary = SandyBrown,
    tertiary = Carmine,
    onPrimary = colorResource(id = R.color.white)
)

@Composable
private fun material3LightColor() = lightColorScheme(
    primary = AmaranthPurple,
    secondary = MellowApricot,
    tertiary = FireEngineRed,
    onPrimary = colorResource(id = R.color.black),

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),

    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AlurmoMaterial3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        Build.VERSION.SDK_INT < Build.VERSION_CODES.S -> material3LightColor()
        darkTheme -> material3DarkColor()
        else -> material3LightColor()
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    Material3Theme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
    Log.e(TAG, "ThemeHandler: Dynamic")
}

@Composable
fun AlurmoMaterialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 11+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val themeHandler =
        if (darkTheme) materialDarkColor()
        else materialLightColor()

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> materialLightColor()
        !dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.R -> themeHandler
        darkTheme -> materialDarkColor()
        else -> materialLightColor()
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    Material2Theme(
        colors = colorScheme,
        content = content
    )
    Log.e(TAG, "ThemeHandler: Not Dynamic")
}
