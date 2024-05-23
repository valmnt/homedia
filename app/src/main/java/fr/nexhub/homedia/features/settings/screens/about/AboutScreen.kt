@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.settings.screens.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.settings.data.SettingsMenuModel
import fr.nexhub.homedia.features.settings.screens.PreferencesContainer

@Composable
fun AboutScreen() {
    val viewModel: AboutViewModel = hiltViewModel()
    PreferencesContainer(preference = SettingsMenuModel("About", "about")) {
        AboutContent(viewModel = viewModel)
    }
}

@Composable
fun AboutText(text: String) {
    Text(
        modifier = Modifier,
        text = text,
        color = LocalContentColor.current,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Preview
@Composable
private fun AboutScreenPrev() {
    AboutScreen()
}
