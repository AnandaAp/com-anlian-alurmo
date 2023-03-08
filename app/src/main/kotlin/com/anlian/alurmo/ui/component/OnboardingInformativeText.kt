package com.anlian.alurmo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anlian.alurmo.R
import java.util.Locale

@Composable
fun OnboardingInformativeText(modifier: Modifier = Modifier) {

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