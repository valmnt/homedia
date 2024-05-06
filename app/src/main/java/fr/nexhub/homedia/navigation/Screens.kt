package fr.nexhub.homedia.navigation

sealed class Screens(val title: String) {
    data object Login : Screens("login")
    data object QuickConnect : Screens("quick_connect")
    data object Home : Screens("home_screen")
    data object Player : Screens("player_screen")
    data object ProductDetail : Screens("product_detail")
    data object WhoIsWatching : Screens("who_is_watching")
    data object Mp3Player : Screens("mp3_player")
    data object ServerRegistration : Screens("server_registration")
}
