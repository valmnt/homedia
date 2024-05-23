package fr.nexhub.homedia.features.settings.navigation

sealed class SettingsScreens(val title: String) {
    object Profile : SettingsScreens("profile")
    object About : SettingsScreens("about")
}
