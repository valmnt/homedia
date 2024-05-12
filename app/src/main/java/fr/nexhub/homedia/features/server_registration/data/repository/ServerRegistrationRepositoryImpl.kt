package fr.nexhub.homedia.features.server_registration.data.repository

import arrow.core.Either
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.features.server_registration.data.remote.ServerAPI
import fr.nexhub.homedia.features.server_registration.domain.repository.ServerRegistrationRepository
import javax.inject.Inject

class ServerRegistrationRepositoryImpl @Inject constructor(
    private val serverAPI: ServerAPI
): ServerRegistrationRepository {
    override suspend fun ping(url: String): Either<NetworkError, String> {
        return Either.catch {
            serverAPI.ping(url)
        }.mapLeft {
            it.toGeneralError()
        }
    }
}