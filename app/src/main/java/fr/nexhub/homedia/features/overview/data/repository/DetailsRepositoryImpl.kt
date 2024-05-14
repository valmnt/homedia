package fr.nexhub.homedia.features.overview.data.repository

import android.graphics.Bitmap
import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.domain.repository.DetailsRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.byteReadChannelToBitmap
import fr.nexhub.homedia.utils.getItemImage
import fr.nexhub.homedia.utils.toDetails
import fr.nexhub.homedia.utils.toItem
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.itemsApi
import org.jellyfin.sdk.model.api.BaseItemKind
import org.jellyfin.sdk.model.api.ItemFields
import java.util.UUID
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(): DetailsRepository {
    override suspend fun getDetails(itemId: UUID): Either<NetworkError, Item> {
        return try {
            val resp = JellyfinManager.api.itemsApi.getItems(
                userId = JellyfinManager.api.userId,
                ids = listOf(itemId),
                includeItemTypes = listOf(BaseItemKind.MOVIE, BaseItemKind.SERIES),
                fields = listOf(
                    ItemFields.OVERVIEW,
                    ItemFields.GENRES
                )
            )
            val baseItem = resp.content.items!!.first()
            var bitmap: Bitmap? = null
            baseItem.getItemImage(350, 500)
            .onRight {
                bitmap = it.byteReadChannelToBitmap()
            }
            baseItem.toItem(bitmap, baseItem.toDetails()).right()
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }
}