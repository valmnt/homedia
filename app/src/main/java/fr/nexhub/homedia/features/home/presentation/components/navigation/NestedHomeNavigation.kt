package fr.nexhub.homedia.features.home.presentation.components.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.nexhub.homedia.features.home.presentation.HomeViewState
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType

@Composable
fun NestedHomeNavigation(
    mainNavController: NavHostController,
    navController: NavHostController,
    state: HomeViewState,
    onItemClick: (HorizontalRowType, List<String>) -> Unit
) {
    NestedHomeScreenNavigation(mainNavController, navController, state, onItemClick)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
private fun NestedHomeNavigationPrev() {
    NestedHomeNavigation(rememberAnimatedNavController(), rememberAnimatedNavController(), HomeViewState()) { _, _ ->}
}
