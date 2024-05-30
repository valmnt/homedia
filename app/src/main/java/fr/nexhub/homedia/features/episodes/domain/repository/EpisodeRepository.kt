package fr.nexhub.homedia.features.episodes.domain.repository

import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID

interface EpisodeRepository {
    suspend fun getEpisodes(itemId: UUID, seasonId: UUID): Pair<List<Episode>, NetworkError?>
}