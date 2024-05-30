package fr.nexhub.homedia.features.overview.domain.usecase

import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.domain.repository.DetailsRepository
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(
    private val detailsRepository: DetailsRepository
) {

    suspend fun execute(itemId: UUID): Pair<Item?, NetworkError?> {
        return detailsRepository.getDetails(itemId)
    }
}