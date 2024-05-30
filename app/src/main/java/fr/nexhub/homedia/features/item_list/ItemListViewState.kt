package fr.nexhub.homedia.features.item_list

import fr.nexhub.homedia.features.common.item.domain.model.Item
import fr.nexhub.homedia.network.error.NetworkError

data class ItemListViewState(
    val isLoading: Boolean = true,
    val error: NetworkError? = null,
    val items: List<Item> = mutableListOf()
)