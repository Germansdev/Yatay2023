package com.example.yatay.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Purple40,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
/**
     Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun YatayTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme =  when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicLightColorScheme(context) else dynamicLightColorScheme(context)

        }

        darkTheme -> LightColorScheme//DarkColorScheme
        else -> LightColorScheme
    }

    val systemUiController = rememberSystemUiController()

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            /**
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()//colorScheme.primary.toArgb()

            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            */

            // with only this: both top and bottom with the same color
            systemUiController.setSystemBarsColor(
                color= if ( darkTheme) Color.White else Color.White,
                darkIcons = !darkTheme
            )
        }
    }
    val defaultBackgroundTheme = BackgroundTheme(
        color = Color.White,
        tonalElevation = 0.dp,
    )

    CompositionLocalProvider(
        LocalBackgroundTheme provides defaultBackgroundTheme,
    ) {

        MaterialTheme(
            colorScheme = colorScheme,//,colorScheme,
            typography = Typography,
            content = content
        )

    }


}

/**
 * A class to model background color and tonal elevation values for Now in Android.
 */
@Immutable
data class BackgroundTheme(
    val color: Color = Color.White,
    val tonalElevation: Dp = Dp.Unspecified,
)

/**
 * A composition local for [BackgroundTheme].
 */
val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }
/**
@Composable
fun YatayBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val color = Color.White//LocalBackgroundTheme.current.color
    val tonalElevation = 0.dp//LocalBackgroundTheme.current.tonalElevation
    Surface(
        color = if (color == Color.Unspecified)  Color.White else Color.White,
        tonalElevation = if (tonalElevation == Dp.Unspecified) 0.dp else 0.dp,//tonalElevation,
        modifier = modifier.fillMaxSize(),
        shadowElevation = 0.dp
    ) {
        CompositionLocalProvider(LocalAbsoluteTonalElevation provides 0.dp) {
            content()
        }
    }
}*/