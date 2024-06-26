@file:OptIn(ExperimentalTvMaterial3Api::class)

package fr.nexhub.homedia.features.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import fr.nexhub.homedia.features.common.components.FocusableItem
import fr.nexhub.homedia.features.settings.data.SettingsMenuModel

@Composable
fun SettingsMenuItem(item: SettingsMenuModel, onMenuSelected: (SettingsMenuModel) -> Unit) {
    when (item.text) {
        SettingsMenuDataItem.Logout.name -> {
            FocusableItem(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                color = ClickableSurfaceDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.error,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    focusedContainerColor = MaterialTheme.colorScheme.onSurface,
                    focusedContentColor = MaterialTheme.colorScheme.error
                ),
                onClick = { onMenuSelected(item) }) {
                Text(
                    text = item.text, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
        else -> {
            FocusableItem(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = { onMenuSelected(item) }) {
                Text(
                    text = item.text, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsMenuItemPrev() {
    SettingsMenuItem(SettingsMenuModel("Menu", "")) {}
}
