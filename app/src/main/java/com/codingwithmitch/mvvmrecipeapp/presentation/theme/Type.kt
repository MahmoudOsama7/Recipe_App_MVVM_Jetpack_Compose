package com.codingwithmitch.mvvmrecipeapp.presentation.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.codingwithmitch.mvvmrecipeapp.R
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


val QuickSandMedium = FontFamily(Font(R.font.quicksand_medium, FontWeight.Medium))
val QuickSandSemiBold = FontFamily(Font(R.font.quicksand_semibold, FontWeight.SemiBold))
val QuickSandLight = FontFamily(Font(R.font.quicksand_light, FontWeight.Light))
val QuickSandRegular = FontFamily(Font(R.font.quicksand_regular, FontWeight.Normal))
val QuickSandBold = FontFamily(Font(R.font.quicksand_bold, FontWeight.Bold))




data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize =30.sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize =24.sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize =20.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize =18.sp
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize =16.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize =14.sp
    ),
    val subtitle1: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize =16.sp
    ),
    val subtitle2: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize =14.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize = 16.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize = 14.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize = 15.sp,
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = QuickSandRegular,
        fontSize = 12.sp
    ),
    val overline: TextStyle = TextStyle(
        fontFamily = QuickSandLight,
        fontSize = 12.sp
    )
)