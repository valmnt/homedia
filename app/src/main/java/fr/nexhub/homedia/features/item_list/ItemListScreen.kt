package fr.nexhub.homedia.features.item_list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import fr.nexhub.homedia.features.common.components.AnimatedBarsLoader
import fr.nexhub.homedia.features.common.components.EmptyView
import fr.nexhub.homedia.features.common.components.ErrorView
import java.util.UUID

@Composable
fun ItemListScreen(id: UUID, title: String, onItemFocus: (itemId: UUID) -> Unit) {
    val viewModel: ItemListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    if (state.isLoading) {
        AnimatedBarsLoader(modifier = Modifier.fillMaxSize())
        viewModel.getItemsFromLibrary(id)
    } else if (state.error != null) {
        ErrorView()
    } else if (state.items.isEmpty()) {
        EmptyView()
    } else {
        ItemListContent(Modifier, state.items, title, onItemFocus)
    }
}

@Preview(device = "id:tv_1080p")
@Composable
fun ItemListScreenPrev() {
    ItemListScreen(UUID.randomUUID(), "Media") {}
}
