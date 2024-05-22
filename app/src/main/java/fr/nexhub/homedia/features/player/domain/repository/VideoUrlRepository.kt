package fr.nexhub.homedia.features.player.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface VideoUrlRepository {
    suspend fun getVideoUrl(id: UUID): Either<NetworkError, String>
}