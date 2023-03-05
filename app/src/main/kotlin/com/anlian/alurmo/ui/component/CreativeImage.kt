package com.anlian.alurmo.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@Composable
fun CreativeImage(
    modifier: Modifier,
    imageVector: ImageVector,
    size: Dp? = null
) {
    val description = "Creative Image"
    Box(modifier = modifier) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            when (size) {
                null -> Icon(
                    imageVector = imageVector,
                    contentDescription = description
                )

                else -> Icon(
                    imageVector = imageVector,
                    contentDescription = description,
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}

@Composable
fun CreativeImage(
    modifier: Modifier,
    painter: Painter,
    size: Dp? = null
) {
    val description = "Creative Image"
    Box(modifier = modifier) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            when (size) {
                null -> Icon(
                    painter = painter,
                    contentDescription = description
                )

                else -> Icon(
                    painter = painter,
                    contentDescription = description,
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}

@Composable
fun CreativeImage(
    modifier: Modifier,
    bitmap: ImageBitmap,
    size: Dp? = null
) {
    val description = "Creative Image"
    Box(modifier = modifier) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center
        ) {
            when (size) {
                null -> Icon(
                    bitmap = bitmap,
                    contentDescription = description
                )

                else -> Icon(
                    bitmap = bitmap,
                    contentDescription = description,
                    modifier = Modifier.size(size)
                )
            }
        }
    }
}