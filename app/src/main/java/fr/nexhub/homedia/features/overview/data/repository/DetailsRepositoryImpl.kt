package fr.nexhub.homedia.features.overview.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.overview.data.datasource.RemoteDetailsDataSource
import fr.nexhub.homedia.features.overview.domain.repository.DetailsRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class DetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDetailsDataSource
): DetailsRepository {
    override suspend fun getDetails(itemId: UUID): Pair<Item?, NetworkError?> {
        return when (val result = remoteDataSource.getDetails(itemId)) {
            is Either.Right -> {
                Timber.tag("GET_DETAILS").d(result.value.id.toString())
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_DETAILS_ERROR").d(result.value.t?.message ?: "")
                null to result.value
            }
        }
    }
}