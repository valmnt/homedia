package fr.nexhub.homedia.features.home.presentation

import fr.nexhub.homedia.features.home.domain.model.Library

data class HomeViewState(
    val isLoading: Boolean = true,
    val libraries: List<Library>? = null,
)