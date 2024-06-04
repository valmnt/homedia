package fr.nexhub.homedia.features.login.withQuickConnect.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

@Composable
@OptIn(ExperimentalTvMaterial3Api::class)
fun QuickConnectTitle(text: String, fontSize: TextUnit) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
        fontSize = fontSize
    )
}