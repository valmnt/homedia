package fr.nexhub.homedia.features.home.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType
import fr.nexhub.homedia.features.home.presentation.components.navigation.NestedHomeNavigation
import fr.nexhub.homedia.features.home.presentation.components.navigation.data.MenuData
import fr.nexhub.homedia.features.home.presentation.components.navigation.topbar.HomeTopBar
import fr.nexhub.homedia.theme.HomediaTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeContent(
    mainNavController: NavHostController,
    state: HomeViewState,
    onItemClick: (HorizontalRowType, List<String>) -> Unit
) {
    val navController = rememberAnimatedNavController()

    val selectedId = remember {
        mutableStateOf(MenuData.menuItems.first().id)
    }

    LaunchedEffect(key1 = Unit) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            selectedId.value = destination.route ?: return@addOnDestinationChangedListener
        }
    }

    HomeTopBar(content = {
        NestedHomeNavigation(mainNavController, navController, state, onItemClick)
    }, selectedId = selectedId.value) {
        navController.navigate(it.id)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun HomeScreenContentPrev() {
    HomediaTheme {
        HomeContent(rememberAnimatedNavController(), HomeViewState()) { _, _ -> }
    }
}
