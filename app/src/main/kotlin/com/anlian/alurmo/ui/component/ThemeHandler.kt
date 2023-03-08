package com.anlian.alurmo.ui.component

import android.os.Build
import androidx.compose.runtime.Composable
import com.anlian.alurmo.ui.theme.AlurmoMaterial3Theme
import com.anlian.alurmo.ui.theme.AlurmoMaterialTheme

@Composable
fun ThemeHandler(callback: @Composable (theme: Unit) -> Unit) {
    when {
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S -> callback(AlurmoMaterialTheme {})
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> callback(AlurmoMaterial3Theme {})
    }
}