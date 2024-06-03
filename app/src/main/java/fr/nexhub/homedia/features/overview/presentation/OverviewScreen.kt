package fr.nexhub.homedia.features.overview.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.AnimatedBarsLoader
import fr.nexhub.homedia.features.common.components.ErrorView
import fr.nexhub.homedia.theme.HomediaTheme
import java.util.UUID

const val ANIMATION_DELAY = 200L

@Composable
fun OverviewScreen(
    itemId: UUID,
    onSeasonClick: (seasonId: UUID) -> Unit,
    onPlayClick: (title: String) -> Unit) {
    val viewModel: OverviewViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    if (state.isLoading) {
        AnimatedBarsLoader(modifier = Modifier.fillMaxSize())
        viewModel.getDetails(itemId)
    } else if (state.error != null) {
        ErrorView()
    } else if (state.item != null) {
        OverviewContent(
            state.item!!,
            state.seasons,
            onSeasonClick = { seasonId ->
                onSeasonClick(seasonId)
            },
            onPlayClick = {
                onPlayClick(state.item!!.title)
            }
        )
    }
}

@Preview(device = Devices.TV_1080p)
@Composable
fun OverviewScreenPrev() {
    HomediaTheme {
        OverviewScreen(UUID.randomUUID(), onSeasonClick = { _ -> }, onPlayClick = { _ ->})
    }
}
