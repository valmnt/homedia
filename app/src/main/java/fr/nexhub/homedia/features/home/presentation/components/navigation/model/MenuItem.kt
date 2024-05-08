package fr.nexhub.homedia.features.home.presentation.components.navigation.model

import androidx.compose.ui.graphics.vector.ImageVector
import fr.nexhub.homedia.features.home.presentation.components.navigation.data.MenuData

data class MenuItem(
    val id: String,
    val text: String,
    val icon: ImageVector? = null,
)

fun MenuItem.isCircleIcon(): Boolean = id == MenuData.settingsItem.id || id == "Search"