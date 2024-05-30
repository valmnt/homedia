package fr.nexhub.homedia.features.common.item.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.common.item.data.datasource.RemoteItemDataSource
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.common.item.domain.repository.ItemRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteItemDataSource
): ItemRepository {

    override suspend fun getItems(libraryId: UUID, limit: Int?): Pair<List<Item>, NetworkError?> {
        return when(val result = remoteDataSource.getItems(libraryId, limit)) {
            is Either.Right -> {
                result.value.forEach { Timber.tag("GET_ITEMS").d(it.title) }
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_ITEMS_ERROR").d(result.value.t?.message ?: "")
                emptyList<Item>() to result.value
            }
        }
    }
}