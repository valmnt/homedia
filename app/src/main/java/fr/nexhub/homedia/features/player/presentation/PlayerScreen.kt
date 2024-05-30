package fr.nexhub.homedia.features.player.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.CircularProgressIndicator
import fr.nexhub.homedia.features.common.components.ErrorView
import java.util.UUID

@Composable
fun PlayerScreen(itemId: UUID, title: String, onBackPressed: () -> Unit) {
    val viewModel: PlayerViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        viewModel.getVideoUrl(itemId)
    } else if (state.error != null || state.url.isNullOrEmpty()) {
        ErrorView()
    } else {
        PlayerContent(
            modifier = Modifier.fillMaxSize(),
            title= title,
            mediaUrl = state.url!!,
            onBackPressed,
        )
    }
}

@Preview
@Composable
private fun PlayerScreenPreview() {
    PlayerScreen(UUID.randomUUID(), "title") {}
}
