package fr.nexhub.homedia.features.player.domain.repository

import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface VideoUrlRepository {
    suspend fun getVideoUrl(id: UUID): Pair<String?, NetworkError?>
}