package fr.nexhub.homedia.features.player.presentation

import fr.nexhub.homedia.network.error.NetworkError

data class PlayerViewState(
    val isLoading: Boolean = true,
    val error: NetworkError? = null,
    val url: String? = null
)