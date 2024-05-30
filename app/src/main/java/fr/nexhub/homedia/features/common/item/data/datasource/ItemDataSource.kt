package fr.nexhub.homedia.features.common.item.data.datasource

import arrow.core.Either
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface ItemDataSource {
    suspend fun getItems(libraryId: UUID, limit: Int?): Either<NetworkError, List<Item>>
}