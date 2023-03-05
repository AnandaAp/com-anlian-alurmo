package com.anlian.alurmo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Help
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale

/**
 * Custom Composable Function for Top Application Bar of this Alurmo Project.
 * This contains 3 UI element, which are Absolute (must included) Back Navigation, Title Text,
 * and Optional Second Navigation.
 *
 * @param title contain title's value, if it value is null then hide the title text
 * @param backIcon contain value for back navigation's icon. it value type is ImageVector
 * @param optionalSecondNavigationIcon contain value for second navigation's icon.
 * it value type is ImageVector. If it value is null then hide the (optional) second navigation.
 * @param optionalSecondNavigationOnClick contain behavior action for optional second navigation.
 * @param backOnClick contain behavior action for back navigation.
 * @author Ananda Apriliansyah Cahya Utama
 * @since March 5, 2023
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlurmoTopBar(
    title: String? = null,
    backIcon: ImageVector = Icons.Default.ArrowBack,
    optionalSecondNavigationIcon: ImageVector? = null,
    optionalSecondNavigationOnClick: () -> Unit = {},
    backOnClick: () -> Unit = {}
) {
    val spacerSize = 0.dp
    val backNavContentDescription = "back navigation icon"
    val helpNavContentDescription = "help navigation icon"

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(width = spacerSize))
                title?.let {
                    Text(
                        text = it.uppercase(Locale.ROOT),
                        fontWeight = Bold
                    )
                }
                IconButton(
                    onClick = optionalSecondNavigationOnClick,
                    content = {
                        optionalSecondNavigationIcon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = helpNavContentDescription
                            )
                        }
                    }
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = backOnClick,
                content = {
                    Icon(
                        imageVector = backIcon,
                        contentDescription = backNavContentDescription
                    )
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(name = "custom top app", group = "component")
private fun AlurmoTopBar() {
    val title = "Alurmo"
    val backIcon = Icons.Default.ArrowBack
    val helpIcon = Icons.Rounded.Help
    val spacerSize = 0.dp
    val backNavContentDescription = "back navigation icon"
    val helpNavContentDescription = "help navigation icon"

    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(width = spacerSize))
                Text(text = title.uppercase(Locale.ROOT), fontWeight = Bold)
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = helpIcon,
                            contentDescription = backNavContentDescription
                        )
                    }
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = { },
                content = {
                    Icon(
                        imageVector = backIcon,
                        contentDescription = helpNavContentDescription
                    )
                }
            )
        }
    )
}