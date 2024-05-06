package fr.nexhub.homedia.features.login.withQuickConnect.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.network.error.NetworkError
import fr.nexhub.homedia.network.toGeneralError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.api.client.exception.InvalidStatusException
import org.jellyfin.sdk.api.client.extensions.quickConnectApi
import org.jellyfin.sdk.model.api.QuickConnectResult
import javax.inject.Inject

class QuickConnectRepositoryImpl @Inject constructor(): QuickConnectRepository {
    override suspend fun initiate(): Either<NetworkError, Response<QuickConnectResult>> {
        return try {
            val quickConnectState = JellyfinManager.api.quickConnectApi.initiate()
            quickConnectState.right()
        } catch (err: InvalidStatusException) {
            err.toGeneralError().left()
        }
    }

    override suspend fun connect(secret: String, onSuccess: (String, Boolean) -> Unit) {
        val scope = CoroutineScope(Dispatchers.Default)
        scope.launch {
            while (isActive) {
                val quickConnectResult = JellyfinManager.api.quickConnectApi.connect(
                    secret = secret
                )
                if (quickConnectResult.content.authenticated) {
                    onSuccess(secret, true)
                    this.cancel()
                }
                delay(5000)
            }
        }
    }
}