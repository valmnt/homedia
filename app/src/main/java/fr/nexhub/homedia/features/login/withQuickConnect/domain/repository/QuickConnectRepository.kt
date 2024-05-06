package fr.nexhub.homedia.features.login.withQuickConnect.domain.repository

import arrow.core.Either
import fr.nexhub.homedia.network.error.NetworkError
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.model.api.QuickConnectResult

interface QuickConnectRepository {
    suspend fun initiate(): Either<NetworkError, Response<QuickConnectResult>>

    suspend fun connect(secret: String, onSuccess: (String, Boolean) -> Unit)
}