package fr.nexhub.homedia.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.home.domain.repository.LibraryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val libraryRepository: LibraryRepository,
): ViewModel() {

    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        getLibraries()
    }

    private fun getLibraries() {
        viewModelScope.launch {
            libraryRepository.getLibraries()
            .onRight { libraries ->
                _state.update {
                    it.copy(libraries = libraries, isLoading = false)
                }
                libraries.forEach { library ->
                    Timber.tag("GET_LIBRARIES").d(library.title)
                }
            }
            .onLeft { error ->
                _state.update {
                    it.copy(isLoading = false)
                }
                Timber.tag("GET_LIBRARIES_ERROR").d(error.t?.message ?: "")
            }
        }
    }
}