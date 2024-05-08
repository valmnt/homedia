package fr.nexhub.homedia.features.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType

@Composable
fun HomeScreen(onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    HomeScreenContent(state, onItemClick)
}
