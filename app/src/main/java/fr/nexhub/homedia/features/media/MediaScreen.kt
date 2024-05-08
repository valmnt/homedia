@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.media

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvGridItemSpan
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.home.presentation.components.carousel.VerticalCarouselItem

@Composable
fun MediaScreen(title: String, onItemFocus: (parent: Int, child: Int) -> Unit) {
    MediaGrid(Modifier, title, onItemFocus)
}

@Composable
fun MediaGrid(modifier: Modifier, title: String, onItemFocus: (parent: Int, child: Int) -> Unit) {
    TvLazyVerticalGrid(
        modifier = modifier,
        columns = TvGridCells.Fixed(5),
        contentPadding = PaddingValues(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 48.dp),
    ) {
        item(span = {
            TvGridItemSpan(5)
        }) {
            GridHeader(title)
        }
        items(30) {
            VerticalCarouselItem(parent = 0, child = 0, onItemFocus)
        }
    }
}

@Composable
fun GridHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(bottom = 24.dp, start = 8.dp),
    )
}

@Preview(device = "id:tv_1080p")
@Composable
fun MediaScreenPrev() {
    MediaScreen("Media") { _, _ -> }
}
