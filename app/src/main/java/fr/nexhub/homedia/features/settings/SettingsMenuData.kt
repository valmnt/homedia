package fr.nexhub.homedia.features.settings

import fr.nexhub.homedia.features.settings.data.SettingsMenuModel
import fr.nexhub.homedia.features.settings.navigation.SettingsScreens
import fr.nexhub.homedia.navigation.Screens

object SettingsMenuData {
    val menu by lazy {
        listOf(
            SettingsMenuModel(SettingsMenuDataItem.Profile.name, SettingsScreens.Profile.title),
            SettingsMenuModel(SettingsMenuDataItem.About.name, SettingsScreens.About.title),
            SettingsMenuModel(SettingsMenuDataItem.Logout.name, Screens.ServerRegistration.title),
        )
    }
}

enum class SettingsMenuDataItem {
    Profile, About, Logout
}