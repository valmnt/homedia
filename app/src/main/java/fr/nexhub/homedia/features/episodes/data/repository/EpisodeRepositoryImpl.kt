package fr.nexhub.homedia.features.episodes.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.episodes.domain.model.Episode
import fr.nexhub.homedia.features.episodes.domain.repository.EpisodeRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.byteReadChannelToBitmap
import fr.nexhub.homedia.utils.getItemImage
import fr.nexhub.homedia.utils.toEpisode
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.tvShowsApi
import org.jellyfin.sdk.model.api.ItemFields
import java.util.UUID
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(): EpisodeRepository {
    override suspend fun getEpisodes(itemId: UUID, seasonId: UUID): Either<NetworkError, List<Episode>> {
        return try {
            val resp = JellyfinManager.api.tvShowsApi.getEpisodes(
                itemId,
                seasonId = seasonId,
                fields = listOf(
                    ItemFields.OVERVIEW
                )
            )
            val items = resp.content.items
            val episodes: MutableList<Episode> = mutableListOf()
            items?.forEach { item ->
                lateinit var episode: Episode
                item.getItemImage(500, 300)
                .onRight {
                    episode = item.toEpisode(it.byteReadChannelToBitmap())
                }
                .onLeft {
                    episode = item.toEpisode(null)
                }
                episodes.add(episode)
            }
            episodes.right()
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }
}