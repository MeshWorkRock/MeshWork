package com.example.meshworkapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.meshworkapp.ui.theme.GradientHigh
import com.example.meshworkapp.ui.theme.GradientLow

@Composable
fun GradientBackGround() {

    // convert the box size to pixels
    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(GradientHigh, GradientLow),
                    start = Offset(0f, 0f), // top left corner
                    end = Offset(boxSize, Float.POSITIVE_INFINITY) // bottom right corner
                )
            )
    ) {
    }
}

@Preview(showBackground = true)
@Composable
fun MyUIPreview(){
    GradientBackGround()
}