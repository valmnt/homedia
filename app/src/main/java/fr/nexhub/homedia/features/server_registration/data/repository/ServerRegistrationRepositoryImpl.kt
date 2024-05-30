package fr.nexhub.homedia.features.server_registration.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.server_registration.data.datasource.ServerRegistrationDataSource
import fr.nexhub.homedia.features.server_registration.domain.repository.ServerRegistrationRepository
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import javax.inject.Inject

class ServerRegistrationRepositoryImpl @Inject constructor(
    private val serverRegistrationDataSource: ServerRegistrationDataSource
): ServerRegistrationRepository {
    override suspend fun ping(url: String): Either<NetworkError, String> {
        return Either.catch {
            serverRegistrationDataSource.ping(url)
        }.mapLeft {
            it.toGeneralError()
        }
    }
}