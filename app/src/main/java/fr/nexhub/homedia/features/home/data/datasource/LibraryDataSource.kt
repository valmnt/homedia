package fr.nexhub.homedia.features.home.data.datasource

import arrow.core.Either
import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.network.error.NetworkError

interface LibraryDataSource {
    suspend fun getLibraries(): Either<NetworkError, List<Library>>
}