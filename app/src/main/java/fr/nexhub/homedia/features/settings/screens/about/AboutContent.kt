package fr.nexhub.homedia.features.settings.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AboutContent(viewModel: AboutViewModel) {
    Column {
        AboutText(text = "Homedia")
        Spacer(modifier = Modifier.height(10.dp))
        AboutText(text = "Contributors: @valmnt")
        Spacer(modifier = Modifier.height(10.dp))
        AboutText(text = "Version: ${viewModel.getAppVersion(LocalContext.current)}")
    }
}