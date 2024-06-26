@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.settings

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import fr.nexhub.homedia.features.settings.navigation.NestedSettingsScreenNavigation

@OptIn(ExperimentalAnimationApi::class, ExperimentalTvMaterial3Api::class)
@Composable
fun SettingsScreen(mainNavController: NavHostController) {
    val viewModel: SettingsViewModel = hiltViewModel()
    val navController = rememberAnimatedNavController()

    Row(
        Modifier
            .fillMaxSize(),
    ) {
        SettingsMenu(
            modifier = Modifier
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.1f))
                .padding(vertical = 32.dp, horizontal = 16.dp),
        ) {
            when (it.text) {
                SettingsMenuDataItem.Logout.name -> {
                    viewModel.logout()
                    mainNavController.navigate(it.navigation)
                }
                else -> navController.navigate(it.navigation)
            }
        }
        SettingsNavigation(navController)
    }
}

@Composable
fun SettingsNavigation(navController: NavHostController) {
    NestedSettingsScreenNavigation(navController)
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun SettingsScreenPrev() {
    SettingsScreen(rememberAnimatedNavController())
}
