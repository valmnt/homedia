package fr.nexhub.homedia.features.episodes.presentation

import fr.nexhub.homedia.features.episodes.domain.model.Episode

data class EpisodesViewState (
    val isLoading: Boolean = true,
    val episodes: List<Episode>? = null
)