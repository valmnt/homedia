package fr.nexhub.homedia.features.overview.domain.usecase

import fr.nexhub.homedia.features.overview.domain.model.Season
import fr.nexhub.homedia.features.overview.domain.repository.SeasonRepository
import java.util.UUID
import javax.inject.Inject

class GetSeasonsUseCase @Inject constructor(
    private val seasonRepository: SeasonRepository
) {

    suspend fun execute(itemId: UUID): List<Season> {
        return seasonRepository.getSeasons(itemId)
    }
}