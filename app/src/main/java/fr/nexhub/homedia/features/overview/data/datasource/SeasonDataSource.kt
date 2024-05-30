package fr.nexhub.homedia.features.overview.data.datasource

import fr.nexhub.homedia.features.overview.domain.model.Season
import java.util.UUID

interface SeasonDataSource {
    suspend fun getSeasons(itemId: UUID): List<Season>
}