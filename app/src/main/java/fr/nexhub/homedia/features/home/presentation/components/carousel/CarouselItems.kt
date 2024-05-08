@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.home.presentation.components.carousel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import fr.nexhub.homedia.widgets.BorderedFocusableItem
import fr.nexhub.utils.testing.tagForItem

@Composable
fun CarouselLibraryItem(
    modifier: Modifier = Modifier,
    text: String,
    parent: Int,
    child: Int,
    onItemClick: (HorizontalRowType, List<String>) -> Unit,
) {
    BorderedFocusableItem(
        onClick = { onItemClick(HorizontalRowType.LIBRARIES, listOf(text)) },
        borderRadius = 12.dp,
        modifier = modifier
            .testTag(tagForItem(parent, child))
            .padding(horizontal = 8.dp)
            .aspectRatio(1.8f)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = text, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun VerticalCarouselItem(parent: Int, child: Int, onItemFocus: (parent: Int, child: Int) -> Unit) {
    BorderedFocusableItem(
        onClick = {
            onItemFocus(parent, child)
        },
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(0.6f),
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Item $parent x $child", textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun CarouselLibraryItemPrev() {
    CarouselLibraryItem(Modifier,"Text", 1, 1) { _, _ ->}
}

@Preview
@Composable
fun VerticalCarouselItemPrev() {
    VerticalCarouselItem(1, 1) { _, _ ->
    }
}
