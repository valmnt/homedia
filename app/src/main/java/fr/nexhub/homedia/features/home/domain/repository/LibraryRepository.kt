package fr.nexhub.homedia.features.home.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.network.error.NetworkError

interface LibraryRepository {
    suspend fun getLibraries(): Either<NetworkError, List<Library>>
}