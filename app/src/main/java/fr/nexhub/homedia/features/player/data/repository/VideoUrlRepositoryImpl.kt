package fr.nexhub.homedia.features.player.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.player.data.datasource.RemoteVideoUrlDataSource
import fr.nexhub.homedia.features.player.domain.repository.VideoUrlRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class VideoUrlRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteVideoUrlDataSource
): VideoUrlRepository {

    override suspend fun getVideoUrl(id: UUID): Pair<String?, NetworkError?> {
        return when (val result = remoteDataSource.getVideoUrl(id)) {
            is Either.Right -> {
                Timber.tag("GET_VIDEO_URL").d(result.value)
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_VIDEO_URL_ERROR").d(result.value.t?.message ?: "")
                null to result.value
            }
        }
    }
}