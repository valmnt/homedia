package fr.nexhub.homedia.features.episodes.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.episodes.data.datasource.RemoteEpisodeDataSource
import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.features.episodes.domain.repository.EpisodeRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteEpisodeDataSource
): EpisodeRepository {
    override suspend fun getEpisodes(itemId: UUID, seasonId: UUID): Pair<List<Episode>, NetworkError?> {
        return when (val result = remoteDataSource.getEpisodes(itemId, seasonId)) {
            is Either.Right -> {
                result.value.forEach { Timber.tag("GET_EPISODES").d(it.id.toString()) }
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_EPISODES_ERROR").d(result.value.t?.message.orEmpty())
                emptyList<Episode>() to result.value
            }
        }
    }
}