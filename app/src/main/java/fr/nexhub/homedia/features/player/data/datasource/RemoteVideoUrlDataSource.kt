package fr.nexhub.homedia.features.player.data.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.videosApi
import java.util.UUID
import javax.inject.Inject

class RemoteVideoUrlDataSource  @Inject constructor(): VideoUrlDataSource {
    override suspend fun getVideoUrl(id: UUID): Either<NetworkError, String> {
        return try {
            val url = JellyfinManager.api.videosApi.getVideoStreamUrl(
                itemId = id,
                static = true
            )
            url.right()
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }
}