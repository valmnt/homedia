package fr.nexhub.homedia.features.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun NestedHomeNavigation(
    navController: NavHostController,
    onItemFocus: (parent: Int, child: Int) -> Unit,
) {
    NestedHomeScreenNavigation(navController, onItemFocus)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
private fun NestedHomeNavigationPrev() {
    NestedHomeNavigation(rememberAnimatedNavController()) { _, _ -> }
}
