package fr.nexhub.homedia.features.episodes.data.datasource

import arrow.core.Either
import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface EpisodeDataSource {
    suspend fun getEpisodes(itemId: UUID, seasonId: UUID): Either<NetworkError, List<Episode>>
}