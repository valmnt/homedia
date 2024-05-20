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
import fr.nexhub.homedia.features.common.components.EmptyView
import fr.nexhub.homedia.features.home.domain.model.Library
import fr.nexhub.utils.testing.SECTIONS_LIST_TAG

@Composable
fun HomeCarousel(
    modifier: Modifier,
    libraries: List<Library>,
    onItemClick: (HorizontalRowType, List<String>) -> Unit
) {
    if (libraries.isEmpty()) {
        EmptyView()
    } else {
        TvLazyColumn(
            modifier.testTag(SECTIONS_LIST_TAG),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            items(1) {
                RowForLibraries(libraries, onItemClick)
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(libraries.size) { parent ->
                RowForRecentItemsInLibrary(libraries[parent], onItemClick)
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun RowForLibraries(libraries: List<Library>, onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    if (libraries.isNotEmpty()) {
        HorizontalCarouselItem(text = stringResource(R.string.libraries)) {
            items(libraries.size) {
                CardCarouselForLibrary(
                    modifier = Modifier,
                    id = libraries[it].id,
                    text = libraries[it].title,
                    onItemClick = onItemClick
                )
            }
        }
    }
}

@Composable
fun RowForRecentItemsInLibrary(library: Library, onItemClick: (HorizontalRowType, List<String>) -> Unit) {
    val recentItems = library.recentItems
    if (recentItems != null) {
        HorizontalCarouselItem(text = "${stringResource(R.string.recently_added_in)} ${library.title}") {
            items(recentItems.size) {
                CardCarouselForRecentItemInLibrary(
                    modifier = Modifier,
                    id = recentItems[it].id,
                    text = recentItems[it].title,
                    bitmap = recentItems[it].image,
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
        HomeCarousel(modifier = Modifier, libraries = listOf()) { _,_ -> }
    }
}