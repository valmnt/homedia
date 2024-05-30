package fr.nexhub.homedia.features.player.domain.usecase

import fr.nexhub.homedia.features.player.domain.repository.VideoUrlRepository
import fr.nexhub.homedia.network.error.NetworkError
import java.util.UUID
import javax.inject.Inject

class GetVideoUrlUseCase @Inject constructor(
    private val videoUrlRepository: VideoUrlRepository
) {

    suspend fun execute(id: UUID): Pair<String?, NetworkError?> {
        return videoUrlRepository.getVideoUrl(id)
    }
}