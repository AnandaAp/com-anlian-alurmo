package com.anlian.alurmo.ui.view.onboarding.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anlian.alurmo.ui.component.AlurmoTopBar
import androidx.compose.material3.ExperimentalMaterial3Api as experimental
import androidx.compose.ui.tooling.preview.Preview as preview

@OptIn(experimental::class)
@preview
@Composable
fun OnBoarding() {
//    val boxVerticalPadding = integerResource(id = R.integer.dimen_42).dp
//    val boxHorizontalPadding = integerResource(id = R.integer.dimen_16).dp

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { AlurmoTopBar() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}