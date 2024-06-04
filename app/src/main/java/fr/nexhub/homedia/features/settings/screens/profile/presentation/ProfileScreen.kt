@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.settings.screens.profile.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import fr.nexhub.homedia.features.common.components.AnimatedBarsLoader
import fr.nexhub.homedia.features.common.components.ErrorView
import fr.nexhub.homedia.features.settings.data.SettingsMenuModel
import fr.nexhub.homedia.features.settings.screens.PreferencesContainer

@Composable
fun ProfileScreen() {
    val viewModel: ProfileViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        AnimatedBarsLoader(modifier = Modifier.fillMaxSize())
        viewModel.getUserInformation()
    } else if (state.error != null || state.user == null) {
        ErrorView()
    } else {
        PreferencesContainer(
            preference = SettingsMenuModel("Profile", "profile")
        ) {
            ProfilesContent(state.user!!)
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun ProfileScreenPrev() {
    ProfileScreen()
}
