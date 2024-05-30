package fr.nexhub.homedia.features.overview.data.datasource

import fr.nexhub.homedia.features.overview.domain.model.Season
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.byteReadChannelToBitmap
import fr.nexhub.homedia.utils.getItemImage
import fr.nexhub.homedia.utils.toSeason
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.tvShowsApi
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class RemoteSeasonDataSource @Inject constructor(): SeasonDataSource {
    override suspend fun getSeasons(itemId: UUID): List<Season> {
        try {
            val resp = JellyfinManager.api.tvShowsApi.getSeasons(itemId)
            val items = resp.content.items
            val seasons: MutableList<Season> = mutableListOf()
            items?.forEach { item ->
                lateinit var season: Season
                item.getItemImage(350, 500)
                    .onRight {
                        season = item.toSeason(it.byteReadChannelToBitmap())
                    }
                    .onLeft {
                        season = item.toSeason(null)
                    }
                seasons.add(season)
            }
            return seasons
        } catch (err: InvalidStatusException) {
            Timber.tag("GET_SEASONS_ERROR").d(err.toGeneralError().t?.message ?: "")
            return listOf()
        }
    }
}