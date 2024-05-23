@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.settings.screens.profile

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import fr.nexhub.homedia.features.settings.data.SettingsMenuModel
import fr.nexhub.homedia.features.settings.screens.PreferencesContainer

@Composable
fun ProfileScreen(onLogoutClick: () -> Unit) {
    val viewModel: ProfileViewModel = hiltViewModel()
    PreferencesContainer(
        preference = SettingsMenuModel("Profile", "profile")
    ) {
        ProfilesContent() {
            viewModel.logout()
            onLogoutClick()
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun ProfileScreenPrev() {
    ProfileScreen() {}
}
