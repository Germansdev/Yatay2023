package com.example.yatay.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ScreenGallery(){
    Text(
        color = if (isSystemInDarkTheme()) Color.White else Color.Black,
        text = "Gallery")
}