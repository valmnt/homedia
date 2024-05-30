package fr.nexhub.homedia.features.item_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.nexhub.homedia.features.common.item.domain.usecase.GetItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ItemListViewState())
    val state = _state.asStateFlow()

    fun getItemsFromLibrary(libraryId: UUID) {
        viewModelScope.launch {
            val (items, error) = getItemsUseCase.execute(libraryId, null)
            _state.update {
                it.copy(isLoading = false, error = error, items = items)
            }
        }
    }
}