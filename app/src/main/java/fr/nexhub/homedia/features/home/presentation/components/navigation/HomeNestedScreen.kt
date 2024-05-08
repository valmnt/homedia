package fr.nexhub.homedia.features.home.presentation.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.nexhub.homedia.features.home.presentation.HomeViewState
import fr.nexhub.homedia.features.home.presentation.components.carousel.HomeCarousel
import fr.nexhub.homedia.features.home.presentation.components.carousel.HorizontalRowType

@Composable
fun HomeNestedScreen(
    state: HomeViewState,
    onItemClick: (HorizontalRowType, List<String>) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        HomeCarousel(
            Modifier.weight(1f),
            state = state,
            onItemClick = onItemClick,
        )
    }
}