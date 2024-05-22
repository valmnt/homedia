package fr.nexhub.homedia.navigation

sealed class Screens(val title: String) {
    data object ServerRegistration : Screens("server_registration")
    data object QuickConnect : Screens("quick_connect")
    data object Home : Screens("home_screen")
    data object ItemList: Screens("item_list")
    data object Overview: Screens("overview")
    data object Episodes: Screens("episodes")
    data object Player: Screens("player")
}
