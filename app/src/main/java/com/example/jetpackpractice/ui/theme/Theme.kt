package com.example.jetpackpractice.ui.theme

import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.jetpackpractice.MainActivity
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.jetpackpractice.LoginSection
import kotlin.math.log


private val DarkColorScheme = darkColorScheme(
    primary = BlueGray,
    primaryContainer = Black,
    surface = Black,
)

private val LightColorScheme = lightColorScheme(
    primary = Black,
    primaryContainer = BlueGray,
    surface = Color.White
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun JetpackPracticeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    activity: Activity = LocalContext.current as MainActivity,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

    val window = calculateWindowSizeClass(activity = activity)
    val config = LocalConfiguration.current

    var typography = CompactTypography
    var appDimens = CompactDimens

    when(window.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            if(config.screenWidthDp <= 360){
                appDimens = CompactSmallDimens
                typography = CompactSmallTypography
            }
            else if(config.screenWidthDp < 599){
                appDimens = CompactMediumDimens
                typography = CompactMediumTypography
            }
            else{
                appDimens = CompactDimens
                typography = CompactTypography
            }
        }

        WindowWidthSizeClass.Medium -> {
            appDimens = MediumDimens
            typography = MediumTypography
        }

        WindowWidthSizeClass.Expanded -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }
    }
    Log.d("Screen-Size","h${window.heightSizeClass} d:${appDimens}")

    AppUtils(appDimens = appDimens) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }


}

val MaterialTheme.dimes
@Composable
get() = localAppDimens.current