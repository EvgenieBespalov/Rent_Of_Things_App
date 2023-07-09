package com.example.rent_of_things_app.screen.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

val shape10 = 10.dp
val shape30 = 30.dp
val shape60 = 60.dp

data class Shape(
    val shape10: RoundedCornerShape = RoundedCornerShape(10.dp),
    val shape30: RoundedCornerShape = RoundedCornerShape(30.dp),
    val shape60: RoundedCornerShape = RoundedCornerShape(60.dp)
)

val LocalShape = compositionLocalOf { Shape() }

val MaterialTheme.shapeScheme: Shape
    @Composable
    @ReadOnlyComposable
    get() = LocalShape.current