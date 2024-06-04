package fr.nexhub.homedia.features.settings.screens.profile.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.settings.screens.profile.data.datasource.RemoteUserDataSource
import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.features.settings.screens.profile.domain.repository.UserRepository
import fr.nexhub.homedia.network.error.NetworkError
import timber.log.Timber
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteUserDataSource
): UserRepository {
    override suspend fun getUserInformation(): Pair<User?, NetworkError?> {
        return when (val result = remoteDataSource.getUserInformation()) {
            is Either.Right -> {
                Timber.tag("GET_USER_INFORMATION").d(result.value.name)
                result.value to null
            }
            is Either.Left -> {
                Timber.tag("GET_USER_INFORMATION_ERROR").d(result.value.t?.message.orEmpty())
                null to result.value
            }
        }
    }
}