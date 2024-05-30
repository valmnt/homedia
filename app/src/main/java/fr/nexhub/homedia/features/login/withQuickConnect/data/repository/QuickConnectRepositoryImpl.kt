package fr.nexhub.homedia.features.login.withQuickConnect.data.repository

import arrow.core.Either
import fr.nexhub.homedia.features.login.withQuickConnect.data.datasource.RemoteQuickConnectDataSource
import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import fr.nexhub.homedia.network.error.NetworkError
import org.jellyfin.sdk.api.client.Response
import org.jellyfin.sdk.model.api.QuickConnectResult
import javax.inject.Inject

class QuickConnectRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteQuickConnectDataSource
): QuickConnectRepository {
    override suspend fun initiate(): Either<NetworkError, Response<QuickConnectResult>> {
        return remoteDataSource.initiate()
    }

    override suspend fun connect(secret: String, onSuccess: (String, Boolean) -> Unit) {
        return remoteDataSource.connect(secret, onSuccess)
    }
}