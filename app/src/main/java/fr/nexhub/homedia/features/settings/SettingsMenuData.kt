package fr.nexhub.homedia.features.settings

import fr.nexhub.homedia.features.settings.data.SettingsMenuModel
import fr.nexhub.homedia.features.settings.navigation.SettingsScreens

object SettingsMenuData {
    val menu by lazy {
        listOf(
            SettingsMenuModel("Profile", SettingsScreens.Profile.title),
            SettingsMenuModel("About", SettingsScreens.About.title),
        )
    }
}
