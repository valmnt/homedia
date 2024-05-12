package fr.nexhub.homedia.features.common.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.common.domain.model.Item
import fr.nexhub.homedia.features.common.domain.repository.ItemRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.byteReadChannelToBitmap
import fr.nexhub.homedia.utils.toItem
import io.ktor.utils.io.ByteReadChannel
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.imageApi
import org.jellyfin.sdk.api.client.extensions.itemsApi
import org.jellyfin.sdk.model.api.BaseItemDto
import org.jellyfin.sdk.model.api.BaseItemKind
import org.jellyfin.sdk.model.api.ImageType
import org.jellyfin.sdk.model.api.SortOrder
import java.util.UUID
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(): ItemRepository {

    override suspend fun getItems(libraryId: UUID, limit: Int?): Either<NetworkError, List<Item>> {
        return try {
            val resp = JellyfinManager.api.itemsApi.getItems(
                userId = JellyfinManager.api.userId,
                parentId = libraryId,
                includeItemTypes = listOf(BaseItemKind.MOVIE, BaseItemKind.SERIES),
                sortBy = listOf("DateCreated"),
                sortOrder = listOf(SortOrder.DESCENDING),
                limit = limit
            )
            val items = resp.content.items
            if (items.isNullOrEmpty()) {
                val list: List<Item> = listOf()
                list.right()
            } else {
                items.map {
                    val bitmap = getItemImage(it).byteReadChannelToBitmap()
                    it.toItem(bitmap)
                }.right()
            }
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }

    private suspend fun getItemImage(item: BaseItemDto): ByteReadChannel {
        return JellyfinManager.api.imageApi.getItemImage(
            itemId = item.id,
            imageType = ImageType.PRIMARY,
            width = 350,
            height = 500
        ).content
    }
}