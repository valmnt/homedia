package fr.nexhub.homedia.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.home.domain.usecase.GetLibrariesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLibrariesUseCase: GetLibrariesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        getLibraries()
    }

    private fun getLibraries() {
        viewModelScope.launch {
            val (libraries, error) = getLibrariesUseCase.execute()
            _state.update {
                it.copy(isLoading = false, error = error, libraries = libraries)
            }
        }
    }
}