package fr.nexhub.homedia.features.item_list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvGridItemSpan
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import fr.nexhub.homedia.common.presentation.CarouselForItems
import fr.nexhub.homedia.features.item_list.components.GridHeader

@Composable
fun ItemListScreenContent(
    modifier: Modifier,
    state: ItemListViewState,
    title: String,
    onItemFocus: () -> Unit
) {
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
        items(state.items.size) {
            CarouselForItems(
                bitmap = state.items[it].image,
                text = state.items[it].title,
                onItemFocus
            )
        }
    }
}