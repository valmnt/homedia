package fr.nexhub.homedia.features.home

import androidx.lifecycle.ViewModel
import fr.nexhub.homedia.features.home.leftmenu.data.MenuData
import fr.nexhub.homedia.features.home.leftmenu.model.MenuItem
import fr.nexhub.homedia.utils.toMutable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val menuItems: StateFlow<List<MenuItem>> = MutableStateFlow(emptyList())
    val menuState: StateFlow<Boolean> = MutableStateFlow(false)
    private val _usedTopBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val usedTopBar: StateFlow<Boolean> = _usedTopBar

    init {
        menuItems.toMutable().value = MenuData.menuItems
    }

    fun menuClosed() {
        menuState.toMutable().value = false
    }

    fun menuOpen() {
        menuState.toMutable().value = true
    }

    fun toggleTopBar(){
        _usedTopBar.value = !_usedTopBar.value
    }
}