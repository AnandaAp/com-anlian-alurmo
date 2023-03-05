package com.anlian.alurmo.ui.view.onboarding.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anlian.alurmo.R
import com.anlian.alurmo.ui.component.CreativeImage
import com.anlian.alurmo.ui.component.OnboardingButtonLayout
import com.anlian.alurmo.ui.state.OnboardingButtonState
import java.util.Locale
import androidx.compose.material3.ExperimentalMaterial3Api as experimental

@OptIn(experimental::class)
@Preview(device = "id:pixel_6_pro", showSystemUi = true)
@Composable
fun OnBoarding() {
    val boxVerticalPadding = integerResource(id = R.integer.dimen_42).dp
    val boxHorizontalPadding = integerResource(id = R.integer.dimen_16).dp
    val informativeComponentPadding = 29.dp
    val creativeImage = painterResource(id = R.drawable.doodle_coffee)
    val imageSize = 240.dp
    val appVersion = stringResource(id = R.string.app_version)

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        vertical = boxVerticalPadding,
                        horizontal = boxHorizontalPadding
                    )
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                InformativeUIComponent(
                    modifier = Modifier.padding(horizontal = informativeComponentPadding)
                )
                Spacer(modifier = Modifier.height(28.dp))

                CreativeImage(
                    modifier = Modifier.fillMaxWidth(),
                    painter = creativeImage,
                    size = imageSize
                )
                Spacer(modifier = Modifier.height(28.dp))

                OnboardingButtonLayout(
                    state = OnboardingButtonState.Onboarding,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(text = stringResource(id = R.string.version, appVersion))
            }
        }
    }
}

@Composable
private fun InformativeUIComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.app_name).uppercase(Locale.ROOT),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(
                id = R.string.from,
                stringResource(R.string.team)
            ).uppercase(Locale.ROOT),
            fontSize = 10.sp,
        )
        Spacer(modifier = Modifier.height(height = 28.dp))
        Text(
            text = stringResource(id = R.string.creative_text),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}