package fr.nexhub.homedia.features.server_registration.domain.usecase

import arrow.core.Either
import fr.nexhub.homedia.features.server_registration.domain.repository.ServerRegistrationRepository
import fr.nexhub.homedia.network.error.NetworkError
import javax.inject.Inject

class PingUseCase @Inject constructor(
    private val serverRegistrationRepository: ServerRegistrationRepository
) {

    suspend fun execute(url: String): Either<NetworkError, String> {
        return serverRegistrationRepository.ping(url)
    }
}