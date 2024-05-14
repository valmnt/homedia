package fr.nexhub.homedia.features.overview.presentation

import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.features.overview.domain.model.Season

data class OverviewViewState(
    val isLoading: Boolean = true,
    val item: Item? = null,
    val seasons: List<Season> = listOf(),
    val episodes: List<Episode> = listOf()
)