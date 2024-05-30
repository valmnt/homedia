package fr.nexhub.homedia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.nexhub.homedia.features.server_registration.data.datasource.ServerRegistrationDataSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideServerApi(): ServerRegistrationDataSource {
        return Retrofit
            .Builder()
            .baseUrl("https://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServerRegistrationDataSource::class.java)
    }
}