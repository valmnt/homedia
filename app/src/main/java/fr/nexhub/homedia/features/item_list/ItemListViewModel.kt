package fr.nexhub.homedia.features.item_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.common.domain.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
): ViewModel() {

    private val _state = MutableStateFlow(ItemListViewState())
    val state = _state.asStateFlow()

    fun getItemsFromLibrary(libraryId: UUID) {
        viewModelScope.launch {
            itemRepository.getItems(libraryId, null)
            .onRight { items ->
                _state.update {
                    it.copy(items = items)
                }
                items.forEach { Timber.tag("GET_ITEM_LIST").d(it.title) }
            }
            .onLeft { error ->
                Timber.tag("GET_ITEM_LIST_ERROR").d(error.t?.message ?: "")
            }
        }
    }
}