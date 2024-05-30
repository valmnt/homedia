package fr.nexhub.homedia.features.episodes.domain.usecase

import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.features.episodes.domain.repository.EpisodeRepository
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val episodeRepository: EpisodeRepository
) {

    suspend fun execute(itemId: UUID, seasonId: UUID): Pair<List<Episode>, NetworkError?> {
        return episodeRepository.getEpisodes(itemId, seasonId)
    }
}