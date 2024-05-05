package fr.nexhub.homedia.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.nexhub.homedia.features.server.registration.data.repository.ServerRegistrationRepositoryImpl
import fr.nexhub.homedia.features.server.registration.domain.repository.ServerRegistrationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideServerRegistrationRepository(impl: ServerRegistrationRepositoryImpl): ServerRegistrationRepository
}