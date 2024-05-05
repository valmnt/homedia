package fr.nexhub.homedia.features.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.nexhub.homedia.features.home.leftmenu.data.MenuData
import fr.nexhub.homedia.features.home.navigation.NestedHomeNavigation
import fr.nexhub.homedia.features.home.navigation.drawer.HomeDrawer
import fr.nexhub.homedia.features.home.navigation.topbar.HomeTopBar
import fr.nexhub.homedia.theme.HomediaTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreenContent(
    onItemFocus: (parent: Int, child: Int) -> Unit,
    usedTopBar: StateFlow<Boolean>,
    toggleNavigationBar: () -> Unit,
    onSongClick: () -> Unit,
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

    usedTopBar.collectAsState().value.let { selectedTopBar ->

        when (selectedTopBar) {
            true -> HomeTopBar(content = {
                NestedHomeNavigation(
                    usedTopBar, toggleNavigationBar, navController, onItemFocus, onSongClick
                )
            }, selectedId = selectedId.value) {
                navController.navigate(it.id)
            }

            false -> HomeDrawer(content = {
                NestedHomeNavigation(
                    usedTopBar, toggleNavigationBar, navController, onItemFocus, onSongClick
                )
            }, selectedId = selectedId.value) {
                navController.navigate(it.id)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenContentPrev() {
    HomediaTheme {
        HomeScreenContent(onItemFocus = { _, _ -> },
            usedTopBar = MutableStateFlow(false),
            toggleNavigationBar = {}) {}
    }
}
