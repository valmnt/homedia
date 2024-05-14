package fr.nexhub.homedia.features.episodes.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.items
import fr.nexhub.homedia.features.common.components.EmptyView
import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.features.episodes.presentation.components.EpisodeItem

@Composable
fun EpisodesContent(episodes: List<Episode>) {
    if (episodes.isEmpty()) {
        EmptyView()
    } else {
        TvLazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            items(episodes) { episode ->
                EpisodeItem(episode)
            }
        }
    }
}

