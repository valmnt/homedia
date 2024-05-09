package fr.nexhub.homedia.features.home.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import fr.nexhub.homedia.features.home.domain.repository.RecentItemRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.toLibrary
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.itemsApi
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val recentItemRepository: RecentItemRepository
): LibraryRepository {
    override suspend fun getLibraries(): Either<NetworkError, List<Library>> {
        return try {
            val resp = JellyfinManager.api.itemsApi.getItems(
                userId = JellyfinManager.api.userId,
            )
            val items = resp.content.items
            val list: MutableList<Library> = mutableListOf()
            if (items.isNullOrEmpty()) {
                list.right()
            } else {
                items.forEach { item ->
                    recentItemRepository.getRecentItems(item.id).onRight { recentItems ->
                        list.add(item.toLibrary(recentItems))
                    }
                }
                list.right()
            }
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }
}