package com.anlian.alurmo.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.anlian.alurmo.R

@Composable
fun AlurmoButton(
    radius: Dp = integerResource(id = R.integer.dimen_8).dp,
    onClick: () -> Unit,
    text: String? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    border: BorderStroke? = null,
    modifier: Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(radius),
        modifier = modifier,
        border = border
    ) {
        text?.let { Text(text = it) }
    }
}

@Composable
fun AlurmoButton(
    radius: Dp = integerResource(id = R.integer.dimen_8).dp,
    onClick: () -> Unit,
    text: String? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    border: BorderStroke? = null,
    modifier: Modifier
) {
    val leadingDescription = "Leading Icon"
    val trailingDescription = "Trailing Icon"
    val horizontalTextPadding = integerResource(id = R.integer.dimen_10).dp

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(radius),
        modifier = modifier,
        border = border
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leadingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = leadingDescription
                )
            }
            text?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = horizontalTextPadding)
                )
            }
            trailingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = trailingDescription
                )
            }
        }

    }
}

@Composable
fun AlurmoButton(
    radius: Dp = integerResource(id = R.integer.dimen_8).dp,
    onClick: () -> Unit,
    text: String? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    leadingIcon: Painter? = null,
    trailingIcon: Painter? = null,
    border: BorderStroke? = null,
    modifier: Modifier
) {
    val leadingDescription = "Leading Icon"
    val trailingDescription = "Trailing Icon"
    val horizontalTextPadding = integerResource(id = R.integer.dimen_10).dp

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(radius),
        modifier = modifier,
        border = border
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leadingIcon?.let {
                Icon(
                    painter = it,
                    contentDescription = leadingDescription
                )
            }
            text?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = horizontalTextPadding)
                )
            }
            trailingIcon?.let {
                Icon(
                    painter = it,
                    contentDescription = trailingDescription
                )
            }
        }

    }
}

@Composable
fun AlurmoButton(
    radius: Dp = integerResource(id = R.integer.dimen_8).dp,
    onClick: () -> Unit,
    text: String? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    leadingIcon: ImageBitmap? = null,
    trailingIcon: ImageBitmap? = null,
    border: BorderStroke? = null,
    modifier: Modifier
) {
    val leadingDescription = "Leading Icon"
    val trailingDescription = "Trailing Icon"
    val horizontalTextPadding = integerResource(id = R.integer.dimen_10).dp

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = textColor
        ),
        shape = RoundedCornerShape(radius),
        modifier = modifier,
        border = border
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            leadingIcon?.let {
                Icon(
                    bitmap = it,
                    contentDescription = leadingDescription
                )
            }
            text?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = horizontalTextPadding)
                )
            }
            trailingIcon?.let {
                Icon(
                    bitmap = it,
                    contentDescription = trailingDescription
                )
            }
        }
    }
}