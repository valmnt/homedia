package fr.nexhub.homedia.features.home.leftmenu.model

import androidx.compose.ui.graphics.vector.ImageVector
import fr.nexhub.homedia.features.home.leftmenu.data.MenuData.settingsItem

data class MenuItem(
    val id: String,
    val text: String,
    val icon: ImageVector? = null,
)

fun MenuItem.isCircleIcon(): Boolean = id == settingsItem.id || id == "Search"