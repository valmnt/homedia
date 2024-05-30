package fr.nexhub.homedia.features.player.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.player.domain.usecase.GetVideoUrlUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val getVideoUrlUseCase: GetVideoUrlUseCase
): ViewModel() {

    private val _state = MutableStateFlow(PlayerViewState())
    val state = _state.asStateFlow()

    fun getVideoUrl(id: UUID) {
        viewModelScope.launch {
            val (url, error) = getVideoUrlUseCase.execute(id)
            _state.update {
                it.copy(isLoading = false, error = error, url = url)
            }
        }
    }
}