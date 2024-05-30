package fr.nexhub.homedia.features.home.domain.usecase

import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import fr.nexhub.homedia.network.error.NetworkError
import javax.inject.Inject

class GetLibrariesUseCase @Inject constructor(
    private val libraryRepository: LibraryRepository
) {
     suspend fun execute(): Pair<List<Library>, NetworkError?> {
        return  libraryRepository.getLibraries()
     }
}