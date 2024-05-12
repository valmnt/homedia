package fr.nexhub.homedia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.nexhub.homedia.features.server_registration.data.remote.ServerAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideServerApi(): ServerAPI {
        return Retrofit
            .Builder()
            .baseUrl("https://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServerAPI::class.java)
    }
}