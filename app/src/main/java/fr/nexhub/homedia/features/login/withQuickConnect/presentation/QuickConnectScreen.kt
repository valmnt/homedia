package fr.nexhub.homedia.features.login.withQuickConnect.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.AnimatedBarsLoader

@Composable
fun QuickConnectScreen(modifier: Modifier = Modifier, goToScreen: () -> Unit) {
    val viewModel: QuickConnectViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    
    if (state.status == null) {
        viewModel.authenticate(goToScreen)
        AnimatedBarsLoader(modifier = modifier.fillMaxSize())
    } else {
        state.status?.let { status ->
            QuickConnectContent(
                status = status,
                code = state.code
            )
        }
    }
}