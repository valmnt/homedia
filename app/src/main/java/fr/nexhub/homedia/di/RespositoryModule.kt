package fr.nexhub.homedia.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.nexhub.homedia.features.common.item.data.repository.ItemRepositoryImpl
import fr.nexhub.homedia.features.common.item.domain.repository.ItemRepository
import fr.nexhub.homedia.features.episodes.data.repository.EpisodeRepositoryImpl
import fr.nexhub.homedia.features.episodes.domain.repository.EpisodeRepository
import fr.nexhub.homedia.features.home.data.repository.LibraryRepositoryImpl
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import fr.nexhub.homedia.features.login.withQuickConnect.data.repository.QuickConnectRepositoryImpl
import fr.nexhub.homedia.features.login.withQuickConnect.domain.repository.QuickConnectRepository
import fr.nexhub.homedia.features.overview.data.repository.DetailsRepositoryImpl
import fr.nexhub.homedia.features.overview.data.repository.SeasonRepositoryImpl
import fr.nexhub.homedia.features.overview.domain.repository.DetailsRepository
import fr.nexhub.homedia.features.overview.domain.repository.SeasonRepository
import fr.nexhub.homedia.features.player.data.repository.VideoUrlRepositoryImpl
import fr.nexhub.homedia.features.player.domain.repository.VideoUrlRepository
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

    @Binds
    @Singleton
    abstract fun provideDetailsRepository(impl: DetailsRepositoryImpl): DetailsRepository

    @Binds
    @Singleton
    abstract fun provideSeasonRepository(impl: SeasonRepositoryImpl): SeasonRepository

    @Binds
    @Singleton
    abstract fun provideEpisodeRepository(impl: EpisodeRepositoryImpl): EpisodeRepository

    @Binds
    @Singleton
    abstract fun provideVideoUrlRepository(impl: VideoUrlRepositoryImpl): VideoUrlRepository
}