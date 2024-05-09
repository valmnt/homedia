package fr.nexhub.homedia.features.home.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.features.home.domain.model.RecentItem
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface RecentItemRepository {
    suspend fun getRecentItems(libraryId: UUID): Either<NetworkError, List<RecentItem>>
}