package fr.nexhub.homedia.features.home.presentation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.nexhub.homedia.features.common.components.CircularProgressIndicator
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType
import fr.nexhub.homedia.features.home.presentation.components.navigation.NestedHomeNavigation
import fr.nexhub.homedia.features.home.presentation.components.navigation.data.MenuData
import fr.nexhub.homedia.features.home.presentation.components.navigation.topbar.HomeTopBar
import fr.nexhub.homedia.theme.HomediaTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreenContent(
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
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else {
            NestedHomeNavigation(navController, state, onItemClick)
        }
    }, selectedId = selectedId.value) {
        navController.navigate(it.id)
    }
}

@Preview
@Composable
fun HomeScreenContentPrev() {
    HomediaTheme {
        HomeScreenContent(HomeViewState()) { _, _ -> }
    }
}
