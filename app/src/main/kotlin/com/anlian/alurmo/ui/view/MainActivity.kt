package com.anlian.alurmo.ui.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anlian.alurmo.ui.theme.AlurmoMaterial3Theme
import com.anlian.alurmo.ui.theme.AlurmoMaterialTheme
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "ActivityHelper"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemeHandler {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun ThemeHandler(callback: @Composable (theme: Unit) -> Unit) {
    when {
        Build.VERSION.SDK_INT < Build.VERSION_CODES.S -> callback(AlurmoMaterialTheme {})
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> callback(AlurmoMaterial3Theme {})
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    name = "Test Preview",
    group = "Test",
    showSystemUi = true,
    device = "spec:width=1440px,height=3120px,dpi=560"
)
@Composable
fun GreetingPreview() {
    AlurmoMaterial3Theme {
        Greeting("Android")
    }
}