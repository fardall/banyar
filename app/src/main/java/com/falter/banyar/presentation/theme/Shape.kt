package com.falter.banyar.presentation.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Created by Falter on 12/11/2023.
 */

val mediumCornerCutShape = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(
        topStart = 16.dp,
        topEnd = 0.dp,
        bottomEnd = 16.dp,
        bottomStart = 0.dp
    ),
    large = RoundedCornerShape(0.dp)
).medium

val shape = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)