package fr.nexhub.homedia.features.overview.domain.repository

import fr.nexhub.homedia.features.overview.domain.model.Season
import java.util.UUID

interface SeasonRepository {
    suspend fun getSeasons(itemId: UUID): List<Season>
}