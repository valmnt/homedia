package fr.nexhub.homedia.features.settings.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun NestedHomeNavigation(mainNavController: NavHostController, navController: NavHostController) {
    NestedSettingsScreenNavigation(mainNavController, navController)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun NestedHomeNavigationPrev() {
    NestedHomeNavigation(rememberAnimatedNavController(), rememberAnimatedNavController())
}
