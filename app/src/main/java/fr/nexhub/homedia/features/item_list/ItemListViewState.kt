package fr.nexhub.homedia.features.item_list

import fr.nexhub.homedia.features.common.item.domain.model.Item

data class ItemListViewState(
    val isLoading: Boolean = true,
    val items: List<Item>? = null
)