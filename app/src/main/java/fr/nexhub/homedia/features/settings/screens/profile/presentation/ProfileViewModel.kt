package fr.nexhub.homedia.features.settings.screens.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.settings.screens.profile.domain.usecase.GetUserInformationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserInformationUseCase: GetUserInformationUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ProfileViewState())
    val state = _state.asStateFlow()

    fun getUserInformation() {
        viewModelScope.launch {
            val (user, error) = getUserInformationUseCase.execute()
            _state.update {
                it.copy(isLoading = false, error = error, user = user)
            }
        }
    }
}