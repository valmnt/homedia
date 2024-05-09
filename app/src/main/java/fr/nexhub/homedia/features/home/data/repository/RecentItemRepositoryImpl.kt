package fr.nexhub.homedia.features.home.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.home.domain.model.RecentItem
import fr.nexhub.homedia.features.home.domain.repository.RecentItemRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.byteReadChannelToBitmap
import fr.nexhub.homedia.utils.toRecentItem
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

class RecentItemRepositoryImpl @Inject constructor(): RecentItemRepository {

    override suspend fun getRecentItems(libraryId: UUID): Either<NetworkError, List<RecentItem>> {
        return try {
            val resp = JellyfinManager.api.itemsApi.getItems(
                userId = JellyfinManager.api.userId,
                parentId = libraryId,
                includeItemTypes = listOf(BaseItemKind.MOVIE, BaseItemKind.SERIES),
                sortBy = listOf("DateCreated"),
                sortOrder = listOf(SortOrder.DESCENDING),
                limit = 10
            )
            val items = resp.content.items
            if (items.isNullOrEmpty()) {
                val list: List<RecentItem> = listOf()
                list.right()
            } else {
                items.map { item ->
                    val bitmap = getRecentItemImage(item).byteReadChannelToBitmap()
                    item.toRecentItem(bitmap)
                }.right()
            }
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }

    private suspend fun getRecentItemImage(item: BaseItemDto): ByteReadChannel {
        return JellyfinManager.api.imageApi.getItemImage(
            itemId = item.id,
            imageType = ImageType.PRIMARY,
            width = 350,
            height = 500
        ).content
    }
}