package fr.nexhub.homedia.features.common.item.domain.usecase

import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.common.item.domain.repository.ItemRepository
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID
import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {

    suspend fun execute(libraryId: UUID, limit: Int?): Pair<List<Item>, NetworkError?> {
        return itemRepository.getItems(libraryId, limit)
    }
}