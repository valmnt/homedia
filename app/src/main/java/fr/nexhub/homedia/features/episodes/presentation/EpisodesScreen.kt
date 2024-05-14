package fr.nexhub.homedia.features.episodes.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.CircularProgressIndicator
import fr.nexhub.homedia.features.common.components.ErrorView
import java.util.UUID

@Composable
fun EpisodesScreen(itemId: UUID, seasonId: UUID) {
    val viewModel: EpisodesViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        viewModel.getEpisodes(itemId, seasonId)
    } else if (state.episodes != null) {
        EpisodesContent(episodes = state.episodes!!)
    } else {
        ErrorView()
    }
}