package fr.nexhub.homedia.features.server_registration.data.remote

import retrofit2.http.GET
import retrofit2.http.Url

interface ServerAPI {
    @GET
    suspend fun ping(@Url url: String): String
}