package fr.nexhub.homedia.features.home.presentation

import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.homedia.network.error.NetworkError

data class HomeViewState(
    val isLoading: Boolean = true,
    val error: NetworkError? = null,
    val libraries: List<Library> = mutableListOf(),
)