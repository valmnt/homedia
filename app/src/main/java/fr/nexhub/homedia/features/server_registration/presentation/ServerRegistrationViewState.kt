package fr.nexhub.homedia.features.server_registration.presentation

import androidx.compose.ui.text.input.TextFieldValue
import fr.nexhub.homedia.network.error.NetworkError

data class ServerRegistrationViewState(
    val isLoading: Boolean = false,
    val error: NetworkError? = null,
    var textFieldValue: TextFieldValue = TextFieldValue()
)