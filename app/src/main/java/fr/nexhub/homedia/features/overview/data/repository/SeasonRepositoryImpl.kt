package fr.nexhub.homedia.features.overview.data.repository

import fr.nexhub.homedia.features.overview.data.datasource.RemoteSeasonDataSource
import fr.nexhub.homedia.features.overview.domain.model.Season
import fr.nexhub.homedia.features.overview.domain.repository.SeasonRepository
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class SeasonRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteSeasonDataSource
): SeasonRepository {
    override suspend fun getSeasons(itemId: UUID): List<Season> {
        val seasons = remoteDataSource.getSeasons(itemId)
        seasons.forEach { season -> Timber.tag("GET_SEASONS").d(season.id.toString()) }
        return seasons
    }
}