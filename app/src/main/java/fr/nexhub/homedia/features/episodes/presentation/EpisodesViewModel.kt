package fr.nexhub.homedia.features.episodes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.episodes.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
): ViewModel() {

    private val _state = MutableStateFlow(EpisodesViewState())
    val state = _state.asStateFlow()

    fun getEpisodes(itemId: UUID, seasonId: UUID) {
        viewModelScope.launch {
            episodeRepository.getEpisodes(itemId, seasonId)
            .onRight { episodes ->
                _state.update {
                    it.copy(episodes = episodes, isLoading = false)
                }
                episodes.forEach { Timber.tag("GET_EPISODES").d(it.id.toString()) }
            }
            .onLeft { error ->
                _state.update {
                    it.copy(isLoading = false)
                }
                Timber.tag("GET_EPISODES_ERROR").d(error.t?.message ?: "")
            }
        }
    }
}