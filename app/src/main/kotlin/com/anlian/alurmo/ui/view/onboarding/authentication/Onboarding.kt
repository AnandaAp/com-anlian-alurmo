package com.anlian.alurmo.ui.view.onboarding.authentication

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.anlian.alurmo.R
import com.anlian.alurmo.ui.component.CreativeImage
import com.anlian.alurmo.ui.component.OnboardingButtonLayout
import com.anlian.alurmo.ui.component.OnboardingInformativeText
import com.anlian.alurmo.ui.state.OnboardingButtonState
import com.anlian.alurmo.viewmodel.OnboardingViewModel
import okhttp3.internal.format
import androidx.compose.material3.ExperimentalMaterial3Api as experimental

private const val TAG = "Onboarding"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboarding(
    viewModel: OnboardingViewModel? = hiltViewModel<OnboardingViewModel>(),
    navController: NavHostController,
    boxVerticalPadding: Dp = integerResource(id = R.integer.dimen_42).dp,
    boxHorizontalPadding: Dp = integerResource(id = R.integer.dimen_16).dp,
    informativeComponentPadding: Dp = 29.dp,
    creativeImage: Painter = painterResource(id = R.drawable.doodle_coffee),
    imageSize: Dp = 240.dp,
    appVersion: String = stringResource(id = R.string.app_version)
) {
    val appName = stringResource(id = R.string.app_name)
    val traceMsg = remember { mutableStateOf(appName) }

    LaunchedEffect(key1 = viewModel) {
        traceMsg.value = format(
            "%s\nappVersion: %s",
            traceMsg.value,
            appVersion
        )
        Log.d(TAG, traceMsg.value)
    }

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
                OnboardingInformativeText(
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
                    modifier = Modifier.fillMaxWidth(),
                    topButtonOnClick = { },
                    bottomButtonOnClick = { viewModel?.navigateToSignIn(navController) }
                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(text = stringResource(id = R.string.version, appVersion))
            }
        }
    }
}

@OptIn(experimental::class)
@Preview(device = "id:pixel_6_pro", showSystemUi = true)
@Composable
fun Onboarding() {
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
                OnboardingInformativeText(
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