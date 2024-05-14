package fr.nexhub.homedia.features.overview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.overview.domain.repository.DetailsRepository
import fr.nexhub.homedia.features.overview.domain.repository.SeasonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository,
    private val seasonRepository: SeasonRepository,
): ViewModel() {

    private val _state = MutableStateFlow(OverviewViewState())
    val state = _state.asStateFlow()

    fun getDetails(itemId: UUID) {
        viewModelScope.launch {
            detailsRepository.getDetails(itemId)
            .onRight { item ->
                getSeasons(item.id)
                _state.update {
                    it.copy(item = item, isLoading = false)
                }
                Timber.tag("GET_DETAILS").d(item.id.toString())
            }
            .onLeft { error ->
                _state.update {
                    it.copy(isLoading = false)
                }
                Timber.tag("GET_DETAILS_ERROR").d(error.t?.message ?: "")
            }
        }
    }

    private suspend fun getSeasons(itemId: UUID) {
        val seasons = seasonRepository.getSeasons(itemId)
        seasons.forEach { season ->
            Timber.tag("GET_SEASONS").d(season.id.toString())
        }
        _state.update { it.copy(seasons = seasons) }
    }
}