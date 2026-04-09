package com.example.jetpackpractice.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import kotlin.random.Random

val Black = Color(0xFF000113)
val LightBlueWhite = Color(0xFFF1F5F9) //Social media background
val BlueGray = Color(0xFF334155)

val ColorScheme.backgroundImageColor
@Composable
get() = if (isSystemInDarkTheme()) BlueGray else DefaultTintColor

val ColorScheme.focusedTextFieldText
@Composable
get() = if(isSystemInDarkTheme()) Black else LightBlueWhite

val ColorScheme.unfocusedTextFieldText
@Composable
get() = if (isSystemInDarkTheme()) Color(0xFF94A3B8) else Color(0xFF475569)

val ColorScheme.textFieldContainer
@Composable
get() = if(isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite