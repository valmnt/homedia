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
import fr.nexhub.homedia.features.episodes.presentation.EpisodesScreen
import fr.nexhub.homedia.features.home.presentation.HomeScreen
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType
import fr.nexhub.homedia.features.item_list.ItemListScreen
import fr.nexhub.homedia.features.login.withQuickConnect.presentation.QuickConnectScreen
import fr.nexhub.homedia.features.overview.presentation.OverviewScreen
import fr.nexhub.homedia.features.player.presentation.PlayerScreen
import fr.nexhub.homedia.features.server_registration.presentation.ServerRegistrationScreen
import java.util.UUID

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
                        navController.navigate("${Screens.ItemList.title}/${args[0]}/${args[1]}")
                    }
                    HorizontalRowType.RECENT_ITEMS -> {
                        navController.navigate("${Screens.Overview.title}/${args[0]}")
                    }
                }
            }
        }

        composable(
            "${Screens.ItemList.title}/{id}/{title}"
        ) {navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getString("id")
            val title = navBackStackEntry.arguments?.getString("title")
            ItemListScreen(UUID.fromString(id), title ?: "Media") { itemId ->
                navController.navigate("${Screens.Overview.title}/$itemId")
            }
        }

        composable(
            "${Screens.Overview.title}/{itemId}",
        ) {navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getString("itemId")
            OverviewScreen(
                UUID.fromString(itemId),
                onSeasonClick = { seasonId ->
                    navController.navigate("${Screens.Episodes.title}/$itemId/$seasonId")
                },
                onPlayClick = { title ->
                    navController.navigate("${Screens.Player.title}/$itemId/$title")
                }
            )
        }

        composable(
            "${Screens.Episodes.title}/{itemId}/{seasonId}",
        ) {navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getString("itemId")
            val seasonId = navBackStackEntry.arguments?.getString("seasonId")
            EpisodesScreen(itemId = UUID.fromString(itemId), seasonId = UUID.fromString(seasonId)) { episodeId, title ->
                navController.navigate("${Screens.Player.title}/$episodeId/$title")
            }
        }

        composable(
            "${Screens.Player.title}/{itemId}/{title}",
        ) { navBackStackEntry ->
            val itemId = navBackStackEntry.arguments?.getString("itemId")
            val title = navBackStackEntry.arguments?.getString("title")
            PlayerScreen(UUID.fromString(itemId), title ?: "Unknown") {
                navController.popBackStack()
            }
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
