package fr.nexhub.homedia.features.server_registration.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.server_registration.domain.usecase.PingUseCase
import fr.nexhub.homedia.managers.JellyfinManager
import fr.nexhub.homedia.utils.JellyfinAPIConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ServerRegistrationViewModel @Inject constructor(
    private val pingUseCase: PingUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ServerRegistrationViewState())
    val state = _state.asStateFlow()

    fun ping(context: Context, onSuccess: () -> Unit) {
        viewModelScope.launch {
            val baseUrl = state.value.textFieldValue.text
            _state.update {
                it.copy(isLoading = true)
            }
            pingUseCase.execute(baseUrl + JellyfinAPIConstants.PING)
            .onRight {
                _state.update {
                    it.copy(isLoading = false)
                }
                JellyfinManager.initSDK(context, baseUrl, accessToken = null, userId = null)
                onSuccess()
                Timber.tag("GET_PING_RESP").d(baseUrl)
            }
            .onLeft { error ->
                _state.update {
                    it.copy(error = error, isLoading = false)
                }
                Timber.tag("GET_PING_ERROR").d(error.details.code.toString() ?: "")
            }
        }
    }
}