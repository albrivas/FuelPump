package com.albrivas.fuelpump.core.uikit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.albrivas.fuelpump.core.uikit.R

val interFamily = FontFamily(
    Font(R.font.inter_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.inter_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.inter_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.inter_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.inter_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.inter_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.inter_thin, FontWeight.Thin, FontStyle.Normal),
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
)


