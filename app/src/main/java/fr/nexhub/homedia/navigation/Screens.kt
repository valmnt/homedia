package fr.nexhub.homedia.navigation

sealed class Screens(val title: String) {
    data object ServerRegistration : Screens("server_registration")
    data object QuickConnect : Screens("quick_connect")
    data object Home : Screens("home_screen")
    data object Media: Screens("media")
}
