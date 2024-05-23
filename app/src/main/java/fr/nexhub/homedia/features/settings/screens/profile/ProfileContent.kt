package fr.nexhub.homedia.features.settings.screens.profile

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.common.components.TvButton

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ProfilesContent(onLogoutClick: () -> Unit)  {
    TvButton(
        modifier = Modifier.width(120.dp),
        onClick = onLogoutClick,
        colors = ButtonDefaults.colors(
            containerColor = MaterialTheme.colorScheme.error,
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.surface,
            focusedContentColor = MaterialTheme.colorScheme.error
        )
    ) {
        Text(
            text = "Logout",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}