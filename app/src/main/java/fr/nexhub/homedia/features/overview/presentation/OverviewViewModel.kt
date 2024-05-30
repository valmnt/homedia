package fr.nexhub.homedia.features.overview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.overview.domain.usecase.GetDetailsUseCase
import fr.nexhub.homedia.features.overview.domain.usecase.GetSeasonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.jellyfin.sdk.model.api.BaseItemKind
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val getSeasonsUseCase: GetSeasonsUseCase,
): ViewModel() {

    private val _state = MutableStateFlow(OverviewViewState())
    val state = _state.asStateFlow()

    fun getDetails(itemId: UUID) {
        viewModelScope.launch {
            val (item, error) = getDetailsUseCase.execute(itemId)
            if (item?.details?.type == BaseItemKind.SERIES) {
                getSeasons(item.id)
            }
            _state.update {
                it.copy(isLoading = false, error = error, item = item)
            }
        }
    }

    private suspend fun getSeasons(itemId: UUID) {
        val seasons = getSeasonsUseCase.execute(itemId)
        _state.update { it.copy(seasons = seasons) }
    }
}