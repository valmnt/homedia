package fr.nexhub.homedia.features.overview.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface DetailsRepository {
    suspend fun getDetails(itemId: UUID): Either<NetworkError, Item>
}