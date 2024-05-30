package fr.nexhub.homedia.features.player.data.datasource

import arrow.core.Either
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface VideoUrlDataSource {
    suspend fun getVideoUrl(id: UUID): Either<NetworkError, String>
}