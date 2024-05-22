package fr.nexhub.homedia.features.player.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.player.domain.repository.VideoUrlRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val videoUrlRepository: VideoUrlRepository
): ViewModel() {

    private val _state = MutableStateFlow(PlayerViewState())
    val state = _state.asStateFlow()

    fun getVideoUrl(id: UUID) {
        viewModelScope.launch {
            videoUrlRepository.getVideoUrl(id)
            .onRight { url ->
                _state.update {
                    it.copy(isLoading = false, url = url)
                }
                Timber.tag("GET_VIDEO_URL").d(url)
            }
            .onLeft { error ->
                _state.update {
                    it.copy(isLoading = false)
                }
                Timber.tag("GET_VIDEO_URL_ERROR").d(error.t?.message ?: "")
            }
        }
    }
}