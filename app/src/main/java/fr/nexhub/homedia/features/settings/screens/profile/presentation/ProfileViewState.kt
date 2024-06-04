package fr.nexhub.homedia.features.settings.screens.profile.presentation

import fr.nexhub.homedia.features.settings.screens.profile.domain.model.User
import fr.nexhub.homedia.network.error.NetworkError

data class ProfileViewState (
    val isLoading: Boolean = true,
    val error: NetworkError? = null,
    val user: User? = null
)