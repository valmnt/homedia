package fr.nexhub.homedia.features.home.presentation.components.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import fr.nexhub.homedia.R
import fr.nexhub.homedia.features.home.presentation.HomeViewState
import fr.nexhub.utils.testing.SECTIONS_LIST_TAG

@Composable
fun HomeCarousel(
    modifier: Modifier,
    state: HomeViewState,
    onItemClick: (HorizontalRowType, List<String>) -> Unit
) {
    TvLazyColumn(
        modifier.testTag(SECTIONS_LIST_TAG),
        contentPadding = PaddingValues(bottom = 100.dp)
    ) {
        items(HorizontalRowType.entries.size) { parent ->
            when(HorizontalRowType.entries[parent]) {
                HorizontalRowType.LIBRARIES -> LibrariesRow(state, parent, onItemClick)
            }
        }
    }
}

@Composable
fun LibrariesRow(state: HomeViewState, parent: Int, onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    if (state.libraries.isNotEmpty()) {
        HorizontalCarouselItem(text = stringResource(R.string.libraries)) {
            items(state.libraries.count()) { child ->
                CarouselLibraryItem(
                    modifier = Modifier,
                    text = state.libraries[child].title,
                    parent = parent,
                    child = child,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeCarouselPrev() {
    Column {
        HomeCarousel(Modifier, HomeViewState()) { _, _ -> }
    }
}