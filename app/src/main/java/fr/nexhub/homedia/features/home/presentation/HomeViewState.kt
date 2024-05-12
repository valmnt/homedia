package fr.nexhub.homedia.features.home.presentation

import fr.nexhub.homedia.features.home.domain.model.Library

data class HomeViewState(
    val libraries: List<Library> = listOf(),
    val isLoading: Boolean = true
)