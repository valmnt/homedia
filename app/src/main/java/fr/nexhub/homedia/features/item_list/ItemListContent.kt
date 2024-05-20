package fr.nexhub.homedia.features.item_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvGridItemSpan
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import fr.nexhub.homedia.features.common.components.CardCarouselForItem
import fr.nexhub.homedia.features.common.components.EmptyView
import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.features.item_list.components.GridHeader
import java.util.UUID

@Composable
fun ItemListContent(
    modifier: Modifier,
    items: List<Item>,
    title: String,
    onItemFocus: (itemId: UUID) -> Unit
) {
    if (items.isEmpty()) {
        EmptyView()
    } else {
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
            items(items.size) {
                CardCarouselForItem(
                    item = items[it],
                    onItemFocus
                )
            }
        }
    }
}