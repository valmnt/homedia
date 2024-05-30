package fr.nexhub.homedia.features.common.item.domain.repository

import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface ItemRepository {
    suspend fun getItems(libraryId: UUID, limit: Int?): Pair<List<Item>, NetworkError?>
}