package fr.nexhub.homedia.features.server_registration.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.AnimatedBarsLoader

@Composable
fun ServerRegistrationScreen(modifier: Modifier = Modifier, goToScreen: () -> Unit) {
    val viewModel: ServerRegistrationViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    if (state.isLoading) {
        AnimatedBarsLoader(modifier = Modifier.fillMaxSize())
    } else {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            ServerRegistrationContent(state = state) {
                viewModel.ping(context) {
                    goToScreen()
                }
            }
        }
    }
}