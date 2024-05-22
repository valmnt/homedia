package fr.nexhub.homedia.features.player.presentation

data class PlayerViewState(
    val isLoading: Boolean = true,
    val url: String? = null
)