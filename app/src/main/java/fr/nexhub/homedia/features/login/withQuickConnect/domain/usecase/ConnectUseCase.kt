package fr.nexhub.homedia.features.login.withQuickConnect.domain.usecase

import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import javax.inject.Inject

class ConnectUseCase @Inject constructor(
    private val quickConnectRepository: QuickConnectRepository
) {

    suspend fun execute(secret: String, onSuccess: (String, Boolean) -> Unit) {
        quickConnectRepository.connect(secret, onSuccess)
    }
}