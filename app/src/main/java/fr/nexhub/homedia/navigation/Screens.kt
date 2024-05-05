package fr.nexhub.homedia.navigation

sealed class Screens(val title: String) {
    data object Login : Screens("login")
    data object LoginToken : Screens("login_token")
    data object Home : Screens("home_screen")
    data object Player : Screens("player_screen")
    data object ProductDetail : Screens("product_detail")
    data object WhoIsWatching : Screens("who_is_watching")
    data object Mp3Player : Screens("mp3_player")
    data object ServerRegistration : Screens("server_registration")
}
