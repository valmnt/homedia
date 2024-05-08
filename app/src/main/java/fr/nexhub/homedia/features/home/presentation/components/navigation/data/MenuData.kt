package fr.nexhub.homedia.features.home.presentation.components.navigation.data

import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.CogSolid
import compose.icons.lineawesomeicons.HomeSolid
import compose.icons.lineawesomeicons.SearchSolid
import compose.icons.lineawesomeicons.UserCircle
import fr.nexhub.homedia.features.home.presentation.components.navigation.NestedScreens.Home
import fr.nexhub.homedia.features.home.presentation.components.navigation.NestedScreens.Search
import fr.nexhub.homedia.features.home.presentation.components.navigation.NestedScreens.Settings
import fr.nexhub.homedia.features.home.presentation.components.navigation.model.MenuItem

object MenuData {
    val menuItems = listOf(
        MenuItem(Home.title, "Home", LineAwesomeIcons.HomeSolid),
        MenuItem(Search.title, "Search", LineAwesomeIcons.SearchSolid),
    )

    val settingsItem = MenuItem(
        Settings.title,
        "Settings",
        LineAwesomeIcons.CogSolid,
    )

    val profile = MenuItem(
        Home.title,
        "My Profile",
        LineAwesomeIcons.UserCircle,
    )
}