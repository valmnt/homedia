package fr.nexhub.homedia.features.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import fr.nexhub.homedia.features.home.HomeNestedScreen
import fr.nexhub.homedia.features.search.SearchScreen
import fr.nexhub.homedia.features.settings.SettingsScreen
import fr.nexhub.homedia.navigation.tabEnterTransition
import fr.nexhub.homedia.navigation.tabExitTransition

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NestedHomeScreenNavigation(
    navController: NavHostController,
    onItemClick: (parent: Int, child: Int) -> Unit,
) {
    AnimatedNavHost(navController = navController, startDestination = NestedScreens.Home.title) {
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
            NestedScreens.Settings.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
            SettingsScreen()
        }
    }
}
