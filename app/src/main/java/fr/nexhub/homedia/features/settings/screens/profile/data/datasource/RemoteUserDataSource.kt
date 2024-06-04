package fr.nexhub.homedia.features.settings.screens.profile.data.datasource

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import fr.nexhub.homedia.utils.toUser
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.userApi
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(): UserDataSource {

    override suspend fun getUserInformation(): Either<NetworkError, User> {
        return try {
            val resp = JellyfinManager.api.userApi.getCurrentUser()
            resp.content.toUser().right()
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }
}