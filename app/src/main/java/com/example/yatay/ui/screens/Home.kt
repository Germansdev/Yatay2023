package com.example.yatay.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ScreenHome (
    modifier: Modifier = Modifier

    ){
    Text(
        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        text = "Home")
}