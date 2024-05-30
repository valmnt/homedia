package fr.nexhub.homedia.features.episodes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.episodes.domain.usecase.GetEpisodesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(EpisodesViewState())
    val state = _state.asStateFlow()

    fun getEpisodes(itemId: UUID, seasonId: UUID) {
        viewModelScope.launch {
            val (episodes, error) = getEpisodesUseCase.execute(itemId, seasonId)
            _state.update {
                it.copy(isLoading = false, error = error, episodes = episodes)
            }
        }
    }
}