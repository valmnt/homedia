package fr.nexhub.homedia.features.home.presentation.components.carousel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
        items(1) { parent ->
            RowForLibraries(state, parent, onItemClick)
            Spacer(modifier = Modifier.height(20.dp))
        }
        items(state.libraries.size) { parent ->
            RowForRecentItemsInLibrary(state, parent, onItemClick)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun RowForLibraries(state: HomeViewState, parent: Int, onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    if (state.libraries.isNotEmpty()) {
        HorizontalCarouselItem(text = stringResource(R.string.libraries)) {
            items(state.libraries.size) { child ->
                CarouselForLibraries(
                    modifier = Modifier,
                    id = state.libraries[child].id,
                    text = state.libraries[child].title,
                    parent = parent,
                    onItemClick = onItemClick,
                    child = child,
                )
            }
        }
    }
}

@Composable
fun RowForRecentItemsInLibrary(state: HomeViewState, parent: Int, onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    val recentItems = state.libraries[parent].recentItems
    if (recentItems != null) {
        HorizontalCarouselItem(text = "${stringResource(R.string.recently_added_in)} ${state.libraries[parent].title}") {
            items(recentItems.size) { child ->
                CarouselForRecentItemsInLibrary(
                    modifier = Modifier,
                    text = recentItems[child].title,
                    bitmap = recentItems[child].image,
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