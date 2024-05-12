@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.item_list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import java.util.UUID

@Composable
fun ItemListScreen(id: UUID, title: String, onItemFocus: () -> Unit) {
    val viewModel: ItemListViewModel = hiltViewModel()
    viewModel.getItemsFromLibrary(id)
    val state by viewModel.state.collectAsState()
    ItemListScreenContent(Modifier, state, title, onItemFocus)
}

@Preview(device = "id:tv_1080p")
@Composable
fun ItemListScreenPrev() {
    ItemListScreen(UUID.randomUUID(), "Media") {}
}
