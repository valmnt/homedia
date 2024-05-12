package fr.nexhub.homedia.features.common.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.features.common.domain.model.Item
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface ItemRepository {
    suspend fun getItems(libraryId: UUID, limit: Int?): Either<NetworkError, List<Item>>
}