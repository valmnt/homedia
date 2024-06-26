package fr.nexhub.homedia.features.home.domain.model

import fr.nexhub.homedia.features.common.item.domain.model.Item
import java.util.UUID

data class Library(
    val id: UUID,
    val title: String,
    val recentItems: List<Item>?
)