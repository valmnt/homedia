package fr.nexhub.homedia.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.nexhub.homedia.features.home.data.repository.LibraryRepositoryImpl
import fr.nexhub.homedia.features.common.data.repository.ItemRepositoryImpl
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import fr.nexhub.homedia.features.common.domain.repository.ItemRepository
import fr.nexhub.homedia.features.login.withQuickConnect.data.repository.QuickConnectRepositoryImpl
import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import fr.nexhub.homedia.features.server_registration.data.repository.ServerRegistrationRepositoryImpl
import fr.nexhub.homedia.features.server_registration.domain.repository.ServerRegistrationRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideServerRegistrationRepository(impl: ServerRegistrationRepositoryImpl): ServerRegistrationRepository

    @Binds
    @Singleton
    abstract fun provideQuickConnectRepository(impl: QuickConnectRepositoryImpl): QuickConnectRepository

    @Binds
    @Singleton
    abstract fun provideLibraryRepository(impl: LibraryRepositoryImpl): LibraryRepository

    @Binds
    @Singleton
    abstract fun provideItemRepository(impl: ItemRepositoryImpl): ItemRepository
}