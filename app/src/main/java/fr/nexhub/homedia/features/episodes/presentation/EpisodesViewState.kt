package fr.nexhub.homedia.features.episodes.presentation

import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.network.error.NetworkError

data class EpisodesViewState (
    val isLoading: Boolean = true,
    val error: NetworkError? = null,
    val episodes: List<Episode> = mutableListOf()
)