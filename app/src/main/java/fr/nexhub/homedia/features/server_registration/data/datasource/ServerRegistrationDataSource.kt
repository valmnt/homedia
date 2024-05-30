package fr.nexhub.homedia.features.server_registration.data.datasource

import retrofit2.http.GET
import retrofit2.http.Url

interface ServerRegistrationDataSource {
    @GET
    suspend fun ping(@Url url: String): String
}