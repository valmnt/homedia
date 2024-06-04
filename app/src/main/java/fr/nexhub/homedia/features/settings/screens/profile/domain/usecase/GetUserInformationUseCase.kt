package fr.nexhub.homedia.features.settings.screens.profile.domain.usecase

import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.features.settings.screens.profile.domain.repository.UserRepository
import fr.nexhub.homedia.network.error.NetworkError
import javax.inject.Inject

class GetUserInformationUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun execute(): Pair<User?, NetworkError?> {
        return userRepository.getUserInformation()
    }
}