package com.example.jetpackpractice.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun AppUtils(
    appDimens : Dimentions,
    content: @Composable ()-> Unit
    ){

    val dimens = remember {
        appDimens
    }
    CompositionLocalProvider(localAppDimens provides dimens) {
        content()
    }
}
val localAppDimens = compositionLocalOf {
    CompactDimens
}