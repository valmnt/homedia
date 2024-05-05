package fr.nexhub.homedia.managers

import android.content.Context
import org.jellyfin.sdk.api.client.ApiClient
import org.jellyfin.sdk.createJellyfin
import org.jellyfin.sdk.model.ClientInfo

object JellyfinManager {

    private lateinit var _api: ApiClient
    val api: ApiClient
        get() = _api


    fun initSDK(currentContext: Context, baseUrl: String, accessToken: String?) {
        val jellyfin =  createJellyfin {
            context = currentContext
            clientInfo = ClientInfo(name = "jellyfin_androidTV_client", version = "1.45")
        }

        _api = jellyfin.createApi(
            baseUrl = baseUrl,
            accessToken = accessToken
        )
    }
}