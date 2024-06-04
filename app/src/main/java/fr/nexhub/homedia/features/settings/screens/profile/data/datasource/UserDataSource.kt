package fr.nexhub.homedia.features.settings.screens.profile.data.datasource

import arrow.core.Either
import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.network.error.NetworkError

interface UserDataSource {
    suspend fun getUserInformation(): Either<NetworkError, User>
}