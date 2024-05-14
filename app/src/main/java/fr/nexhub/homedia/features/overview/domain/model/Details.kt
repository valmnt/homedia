package fr.nexhub.homedia.features.overview.domain.model

import org.jellyfin.sdk.model.api.BaseItemKind

data class Details(
    val type: BaseItemKind,
    val communityRating: Float?,
    val productionYear: Int?,
    val overview: String?,
    val duration: String?,
    val genres: List<String>?
)