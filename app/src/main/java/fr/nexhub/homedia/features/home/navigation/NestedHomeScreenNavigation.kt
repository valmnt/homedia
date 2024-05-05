package fr.nexhub.homedia.features.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import fr.nexhub.homedia.features.favorites.FavoritesScreen
import fr.nexhub.homedia.features.home.HomeNestedScreen
import fr.nexhub.homedia.features.movies.MoviesScreen
import fr.nexhub.homedia.features.search.SearchScreen
import fr.nexhub.homedia.features.settings.SettingsScreen
import fr.nexhub.homedia.features.songs.SongsScreen
import fr.nexhub.homedia.navigation.tabEnterTransition
import fr.nexhub.homedia.navigation.tabExitTransition
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NestedHomeScreenNavigation(
    usedTopBar: StateFlow<Boolean>,
    toggleTopBar: () -> Unit,
    navController: NavHostController,
    onItemClick: (parent: Int, child: Int) -> Unit,
    onSongClick: () -> Unit
) {
    AnimatedNavHost(navController = navController, startDestination = NestedScreens.Home.title) {
        // e.g will add auth routes here if when we will extend project
        composable(
            NestedScreens.Home.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            HomeNestedScreen(onItemFocus = { _, _ -> }, onItemClick = onItemClick)
        }

        composable(
            NestedScreens.Search.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            SearchScreen()
        }

        composable(
            NestedScreens.Movies.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            MoviesScreen(onItemClick)
        }

        composable(
            NestedScreens.Songs.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            SongsScreen(onSongClick)
        }

        composable(
            NestedScreens.Favorites.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            FavoritesScreen()
        }

        composable(
            NestedScreens.Settings.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            SettingsScreen(toggleTopBar = toggleTopBar, usedTopBar = usedTopBar)
        }
    }
}
