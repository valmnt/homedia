package fr.nexhub.homedia.features.settings.screens.profile.domain.repository

import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.network.error.NetworkError

interface UserRepository {
    suspend fun getUserInformation(): Pair<User?, NetworkError?>
}