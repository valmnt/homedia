@file:OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)

package fr.nexhub.homedia.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import md_theme_dark_background
import md_theme_dark_error
import md_theme_dark_inverseSurface
import md_theme_dark_onSurface
import md_theme_dark_primary
import md_theme_dark_surface
import md_theme_dark_surfaceVariant

private val DarkColors = darkColorScheme(
    background = md_theme_dark_background,
    primary = md_theme_dark_primary,
    error = md_theme_dark_error,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    inverseSurface = md_theme_dark_inverseSurface
)

@Composable
fun HomediaTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography,
        shapes = Shapes,
        content = {
            CompositionLocalProvider(LocalContentColor provides DarkColors.primary) {
                Box(modifier = Modifier.semantics {
                    testTagsAsResourceId = true
                }) {
                    content()
                }
            }
        },
    )
}
