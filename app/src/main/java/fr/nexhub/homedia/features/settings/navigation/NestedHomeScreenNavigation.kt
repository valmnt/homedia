package fr.nexhub.homedia.features.settings.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import fr.nexhub.homedia.features.settings.screens.about.AboutScreen
import fr.nexhub.homedia.features.settings.screens.profile.presentation.ProfileScreen
import fr.nexhub.homedia.navigation.tabEnterTransition
import fr.nexhub.homedia.navigation.tabExitTransition

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NestedSettingsScreenNavigation(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = SettingsScreens.Profile.title,
    ) {
        // e.g will add auth routes here if when we will extend project
        composable(
            SettingsScreens.Profile.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() },
        ) {
            ProfileScreen()
        }
        composable(
            SettingsScreens.About.title,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() },
        ) {
            AboutScreen()
        }
    }
}
