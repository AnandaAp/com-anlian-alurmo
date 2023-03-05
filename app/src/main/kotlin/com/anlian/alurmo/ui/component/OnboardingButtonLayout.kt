package com.anlian.alurmo.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.anlian.alurmo.R
import com.anlian.alurmo.ui.state.OnboardingButtonState
import com.anlian.alurmo.ui.state.OnboardingButtonState.Onboarding
import com.anlian.alurmo.ui.state.OnboardingButtonState.SignIn
import com.anlian.alurmo.ui.state.OnboardingButtonState.SignUp
import java.util.Locale

@Composable
fun OnboardingButtonLayout(
    state: OnboardingButtonState,
    modifier: Modifier,
    radius: Dp = integerResource(id = R.integer.dimen_8).dp
) {
    val provider = stringResource(id = R.string.google)
    val topBtnText = when (state) {
        SignIn -> stringResource(id = R.string.sign_in_label).uppercase(Locale.ROOT)
        Onboarding -> stringResource(id = R.string.sign_up_label).uppercase(Locale.ROOT)
        SignUp -> stringResource(id = R.string.sign_up_label).uppercase(Locale.ROOT)
    }
    val bottomBtnText = when (state) {
        SignIn -> stringResource(
            id = R.string.authentication_with_provider,
            topBtnText,
            provider
        ).uppercase(Locale.ROOT)

        Onboarding -> stringResource(id = R.string.sign_in_label).uppercase(Locale.ROOT)
        SignUp -> stringResource(
            id = R.string.authentication_with_provider,
            topBtnText,
            provider
        ).uppercase(Locale.ROOT)
    }
    val isEnabled = when (state) {
        SignIn -> true
        Onboarding -> false
        SignUp -> true
    }
    val secondBtnTrailingIcon =
        if (state != Onboarding) painterResource(id = R.drawable.google)
        else null

    Box(modifier = modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AlurmoButton(
                onClick = { },
                text = topBtnText,
                radius = radius,
                modifier = modifier,
            )

            InformativeSlice(
                modifier = Modifier.fillMaxWidth(),
                isEnabled = isEnabled
            )

            AlurmoButton(
                onClick = { },
                modifier = modifier,
                radius = radius,
                text = bottomBtnText,
                textColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary,
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary
                ),
                leadingIcon = secondBtnTrailingIcon
            )
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    name = "Alurmo Button", group = "Component"
)
@Composable
fun OnboardingButtonLayout() {
    val modifier = Modifier.fillMaxWidth()
    val radius = integerResource(id = R.integer.dimen_8).dp
    val stateLabel = stringResource(id = R.string.sign_in_label)
    val provider = stringResource(id = R.string.google)
    val border = integerResource(id = R.integer.dimen_2).dp
    val bottomBtnText =
        stringResource(id = R.string.authentication_with_provider, stateLabel, provider).uppercase(
            Locale.ROOT
        )
    val secondBtnTrailingIcon = painterResource(id = R.drawable.google)

    Box(modifier = modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AlurmoButton(
                onClick = { },
                modifier = modifier,
                radius = radius,
                text = stateLabel.uppercase(Locale.ROOT)
            )

            InformativeSlice(modifier = Modifier.fillMaxWidth(), isEnabled = true)

            AlurmoButton(
                onClick = { },
                modifier = modifier,
                radius = radius,
                text = bottomBtnText,
                textColor = MaterialTheme.colorScheme.primary,
                color = MaterialTheme.colorScheme.onPrimary,
                border = BorderStroke(
                    width = border,
                    color = MaterialTheme.colorScheme.primary
                ),
                leadingIcon = secondBtnTrailingIcon
            )
        }
    }
}

@Composable
private fun InformativeSlice(
    modifier: Modifier,
    isEnabled: Boolean = false,
    verticalMargin: Dp = 20.dp,
    thickness: Dp = integerResource(id = R.integer.dimen_1).dp,
    betweenDividerPadding: Dp = integerResource(id = R.integer.dimen_10).dp,
    text: String = stringResource(id = R.string.or_label)
) {
    if (isEnabled) {
        ConstraintLayout(modifier = modifier.padding(vertical = verticalMargin)) {
            val (right, mid, left) = createRefs()

            Divider(
                modifier = Modifier.constrainAs(right) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(mid.end)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
                thickness = thickness,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = text,
                modifier = Modifier
                    .padding(horizontal = betweenDividerPadding)
                    .constrainAs(mid) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
            Divider(
                modifier = Modifier.constrainAs(left) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(mid.start)
                    width = Dimension.fillToConstraints
                },
                thickness = thickness,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    } else {
        Spacer(modifier = Modifier.height(integerResource(id = R.integer.dimen_20).dp))
    }
}