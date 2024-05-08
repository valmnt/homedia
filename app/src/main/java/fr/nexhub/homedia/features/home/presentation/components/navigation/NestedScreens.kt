package fr.nexhub.homedia.features.home.presentation.components.navigation

sealed class NestedScreens(val title: String) {
    data object Home : NestedScreens("home")
    data object Search : NestedScreens("search")
    data object Settings : NestedScreens("settings")
}
