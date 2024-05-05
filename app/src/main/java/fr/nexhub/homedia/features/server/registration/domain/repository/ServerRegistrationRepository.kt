package fr.nexhub.homedia.features.server.registration.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.network.error.NetworkError

interface ServerRegistrationRepository {
    suspend fun ping(url: String): Either<NetworkError, String>
}