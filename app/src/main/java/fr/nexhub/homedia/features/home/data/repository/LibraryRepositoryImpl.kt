package fr.nexhub.homedia.features.home.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.home.data.datasource.RemoteLibraryDataSource
import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteLibraryDataSource
): LibraryRepository {
    override suspend fun getLibraries(): Pair<List<Library>, NetworkError?> {
        return when(val result = remoteDataSource.getLibraries()) {
            is Either.Right -> {
                result.value.forEach { library -> Timber.tag("GET_LIBRARIES").d(library.title) }
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_LIBRARIES_ERROR").d(result.value.t?.message ?: "")
                emptyList<Library>() to result.value
            }
        }
    }
}