package fr.nexhub.homedia.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import fr.nexhub.homedia.features.home.presentation.HomeScreen
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType
import fr.nexhub.homedia.features.login.withQuickConnect.presentation.QuickConnectScreen
import fr.nexhub.homedia.features.media.MediaScreen
import fr.nexhub.homedia.features.server.registration.presentation.ServerRegistrationScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController, startDestination: String) {
    AnimatedNavHost(navController = navController, startDestination = startDestination) {
        composable(
            Screens.ServerRegistration.title,
        ) {
            ServerRegistrationScreen {
                navController.navigateSingleTopTo(Screens.QuickConnect.title)
            }
        }

        composable(
            Screens.QuickConnect.title,
        ) {
            QuickConnectScreen {
                navController.navigateSingleTopTo(Screens.Home.title)
            }
        }

        composable(
            Screens.Home.title
        ) {
            HomeScreen { horizontalRowType, args ->
                when(horizontalRowType) {
                    HorizontalRowType.LIBRARIES -> {
                        navController.navigate("${Screens.Media.title}/${args.first()}")
                    }
                }
            }
        }

        composable(
            "${Screens.Media.title}/{title}"
        ) {navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getString("title")
            MediaScreen(title ?: "Media") { _, _ -> }
        }
    }
}

fun tabExitTransition(
    duration: Int = 500,
) = fadeOut(tween(duration / 2, easing = LinearEasing))

fun tabEnterTransition(
    duration: Int = 500,
    delay: Int = duration - 350,
) = fadeIn(tween(duration, duration - delay))

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id,
        ) {
            saveState = true
            inclusive = true
        }
        launchSingleTop = true
        restoreState = true
    }
