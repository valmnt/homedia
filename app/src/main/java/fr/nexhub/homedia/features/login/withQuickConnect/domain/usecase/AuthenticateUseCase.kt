package fr.nexhub.homedia.features.login.withQuickConnect.domain.usecase

import arrow.core.Either
import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import fr.nexhub.homedia.network.error.NetworkError
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.model.api.QuickConnectResult
import javax.inject.Inject

class AuthenticateUseCase @Inject constructor(
    private val quickConnectRepository: QuickConnectRepository
) {

    suspend fun execute(): Either<NetworkError, Response<QuickConnectResult>> {
        return quickConnectRepository.initiate()
    }
}