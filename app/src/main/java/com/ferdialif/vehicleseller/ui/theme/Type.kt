package com.ferdialif.vehicleseller.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ferdialif.vehicleseller.core.font.poppins

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    displayLarge = TextStyle(fontFamily = poppins),
    displayMedium = TextStyle(fontFamily = poppins),
    displaySmall = TextStyle(fontFamily = poppins),
    headlineLarge = TextStyle(fontFamily = poppins),
    headlineMedium = TextStyle(fontFamily = poppins),
    headlineSmall = TextStyle(fontFamily = poppins),
    titleLarge = TextStyle(fontFamily = poppins),
    titleMedium = TextStyle(fontFamily = poppins),
    titleSmall = TextStyle(fontFamily = poppins),
    bodyMedium = TextStyle(fontFamily = poppins),
    bodySmall = TextStyle(fontFamily = poppins),
    labelLarge = TextStyle(fontFamily = poppins),
    labelMedium = TextStyle(fontFamily = poppins),
    labelSmall = TextStyle(fontFamily = poppins)
)